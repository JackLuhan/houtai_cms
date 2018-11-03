package com.ypxx.manage.system.role.service.impl;

import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.permission.service.IPermissionService;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.role.repository.IRoleRepository;
import com.ypxx.manage.system.role.service.IRoleService;
import com.ypxx.manage.system.type.entity.TypeEntity;
import com.ypxx.manage.system.type.service.ITypeService;
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
 * Created by xuwei on 2018/10/6.
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;
    private final IPermissionService permissionService;
    private final ITypeService typeService;

    @Autowired
    public RoleServiceImpl(IRoleRepository roleRepository, IPermissionService permissionService, ITypeService typeService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
        this.typeService = typeService;
    }

    @Override
    public List<RoleEntity> list() {
        Specification<RoleEntity> specification = (Specification<RoleEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return roleRepository.findAll(specification);
    }

    @Override
    public RoleEntity findRoleById(Long roleId) {
        if (null == roleId) return null;
        Specification<RoleEntity> specification = (Specification<RoleEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), roleId));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<RoleEntity> type = roleRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public Page<RoleEntity> roleList(Integer pageNum, Integer pageSize, String name, Date startTime, Date endTime) {
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<RoleEntity> specification = (Specification<RoleEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("role"), "%" + name + "%"));
            }
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return roleRepository.findAll(specification, pageable);
    }

    @Override
    public RoleEntity add(String name, Long[] typeId, Long[] permId, String desc) {
        if (name == null || "".equals(name)) return null;
        Set<Long> set = new HashSet<>();
        if (typeId != null){
            for (Long aLong : typeId) {
                TypeEntity types = typeService.findOne(aLong);
                if (types != null) {
                    types.getPermissions().forEach(p->{
                        set.add(p.getId());
                    });
                }
            }
        }
        if (permId != null){
            set.addAll(Arrays.asList(permId));
        }
        List<PermissionEntity> list = new ArrayList<>();
        for (Long aLong : set) {
            PermissionEntity permission = permissionService.findById(aLong);
            list.add(permission);
        }
        RoleEntity role = new RoleEntity();
        role.setRole(name);
        role.setDescription(desc);
        role.setPermissions(list);
        return roleRepository.save(role);
    }

    @Override
    public RoleEntity delete(Long id) {
        if (null == id) return null;
        RoleEntity type = roleRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return roleRepository.save(type);
    }

    @Override
    public RoleEntity update(Long id, String name, Long[] typeId, Long[] permId, String desc) {
        RoleEntity role = roleRepository.getOne(id);
        role.getPermissions().removeAll(role.getPermissions());
        Set<Long> set = new HashSet<>();
        if (typeId != null){
            for (Long aLong : typeId) {
                TypeEntity types = typeService.findOne(aLong);
                if (types != null) {
                    types.getPermissions().forEach(p->{
                        set.add(p.getId());
                    });
                }
            }
        }
        if (permId != null){
            set.addAll(Arrays.asList(permId));
        }
        List<PermissionEntity> list = new ArrayList<>();
        for (Long aLong : set) {
            PermissionEntity permission = permissionService.findById(aLong);
            list.add(permission);
        }
        role.setRole(name);
        role.setDescription(desc);
        role.setPermissions(list);
        return roleRepository.save(role);
    }
}
