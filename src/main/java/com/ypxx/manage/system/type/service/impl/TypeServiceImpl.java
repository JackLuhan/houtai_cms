package com.ypxx.manage.system.type.service.impl;

import com.ypxx.manage.system.type.entity.TypeEntity;
import com.ypxx.manage.system.type.repository.ITypeRepository;
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
public class TypeServiceImpl implements ITypeService {

    private final ITypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(ITypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public TypeEntity add(String name) {
        TypeEntity type = new TypeEntity();
        type.setName(name);
        return typeRepository.save(type);
    }

    @Override
    public Page<TypeEntity> page(Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<TypeEntity> specification = (Specification<TypeEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return typeRepository.findAll(specification,pageable);
    }

    @Override
    public TypeEntity delete(Long id) {
        if (null == id) return null;
        TypeEntity type = typeRepository.findById(id).orElse(null);
        Objects.requireNonNull(type).setDel(1);
        return typeRepository.save(type);
    }

    @Override
    public List<TypeEntity> list() {
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        Specification<TypeEntity> specification = (Specification<TypeEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return typeRepository.findAll(specification,sort);
    }

    @Override
    public TypeEntity findOne(Long id) {
        if (null == id) return null;
        Specification<TypeEntity> specification = (Specification<TypeEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("id"), id));
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Optional<TypeEntity> type = typeRepository.findOne(specification);
        return type.orElse(null);
    }

    @Override
    public TypeEntity edit(TypeEntity type) {
        if (null == type) return null;
        TypeEntity typeEntity = typeRepository.getOne(type.getId());
        typeEntity.setName(type.getName());
        return typeRepository.save(typeEntity);
    }
}
