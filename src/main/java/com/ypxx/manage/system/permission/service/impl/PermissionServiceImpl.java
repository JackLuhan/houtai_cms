package com.ypxx.manage.system.permission.service.impl;

import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.permission.repository.IPermissionRepository;
import com.ypxx.manage.system.permission.service.IPermissionService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by xuwei on 2018/10/8.
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    private final IPermissionRepository permissionRepository;
    private final ITypeService typeService;

    @Autowired
    public PermissionServiceImpl(IPermissionRepository permissionRepository, ITypeService typeService) {
        this.permissionRepository = permissionRepository;
        this.typeService = typeService;
    }

    @Override
    public Page<PermissionEntity> permissionList(Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<PermissionEntity> specification = (Specification<PermissionEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return permissionRepository.findAll(specification,pageable);
    }

    @Override
    public PermissionEntity add(Long typeId, String url, String name) {
        PermissionEntity permission = new PermissionEntity();
        TypeEntity type = typeService.findOne(typeId);
        List<TypeEntity> types = new ArrayList<>();
        types.add(type);
        permission.setTypes(types);
        permission.setUrl(url);
        permission.setName(name);
        return permissionRepository.save(permission);
    }

    @Override
    public PermissionEntity findById(Long aLong) {
        if (aLong == null) return null;
        Specification<PermissionEntity> specification = (Specification<PermissionEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), aLong));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<PermissionEntity> type = permissionRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public List<PermissionEntity> findPermissionListByUsername(String username) {
        return permissionRepository.findPermissionListByUsername(username);
    }

    @Override
    public PermissionEntity edit(PermissionEntity permission,Long typeId) {
        if (null == permission) return null;
        PermissionEntity entity = permissionRepository.getOne(permission.getId());
        TypeEntity type = typeService.findOne(typeId);
        List<TypeEntity> types = new ArrayList<>();
        types.add(type);
        entity.setName(permission.getName());
        entity.setUrl(permission.getUrl());
        entity.setTypes(types);
        return permissionRepository.save(entity);
    }

    @Override
    public PermissionEntity del(Long id) {
        if (null == id) return null;
        PermissionEntity permission = permissionRepository.findById(id).orElse(null);
        Objects.requireNonNull(permission).setDel(1);
        return permissionRepository.save(permission);
    }
}
