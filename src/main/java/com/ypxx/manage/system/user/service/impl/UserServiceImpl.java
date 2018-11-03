package com.ypxx.manage.system.user.service.impl;

import com.ypxx.manage.common.utils.PasswordUtils;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.role.service.IRoleService;
import com.ypxx.manage.system.user.entity.UserEntity;
import com.ypxx.manage.system.user.repository.IUserRepository;
import com.ypxx.manage.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.*;


/**
 * Created by xuwei on 2018/10/5.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IRoleService roleService;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, IRoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public UserEntity addUser(UserEntity user, Long roleId) {
        if (null == user || null == roleId) return null;
        RoleEntity role = roleService.findRoleById(roleId);
        user.setPassword(PasswordUtils.entryPassword(user.getPassword()));
        user.setName(role.getRole());
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public Page<UserEntity> page(Integer pageNum, Integer pageSize, String name, Date start, Date end) {
        Sort sort = new Sort(Sort.Direction.ASC, "createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<UserEntity> specification = (Specification<UserEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("username"), "%" + name + "%"));
            }
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return userRepository.findAll(specification, pageable);
    }

    @Override
    public UserEntity delete(Long id) {
        if (null == id) return null;
        UserEntity type = userRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return userRepository.save(type);
    }

    @Override
    public UserEntity findById(Long id) {
        if (null == id) return null;
        Specification<UserEntity> specification = (Specification<UserEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<UserEntity> type = userRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public List<UserEntity> list() {
        Sort sort = new Sort(Sort.Direction.ASC, "createTime");
        Specification<UserEntity> specification = (Specification<UserEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return userRepository.findAll(specification, sort);
    }

    @Override
    public UserEntity update(UserEntity user, Long roleId) {
        UserEntity one = userRepository.getOne(user.getId());
        if (null == one || null == roleId) return null;
        RoleEntity role = roleService.findRoleById(roleId);
        one.setPassword(PasswordUtils.entryPassword(user.getPassword()));
        one.setName(role.getRole());
        one.setRole(role);
        one.setUsername(user.getUsername());
        one.setPhone(user.getPhone());
        one.setEmail(user.getEmail());
        return userRepository.save(one);
    }
}
