package com.ypxx.manage.manage.product.service.impl;

import com.ypxx.manage.manage.product.dao.ProductTypeDao;
import com.ypxx.manage.manage.product.entity.ProductTypeEntity;
import com.ypxx.manage.manage.product.service.TypeService;
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

@Service
@Transactional
public class ProductTypeServiceImpl implements TypeService {

    @Autowired
    ProductTypeDao productTypeDao;

    @Override
    public void addType(ProductTypeEntity type) {
        productTypeDao.save(type);
    }

    @Override
    public void deleteType(Long id) {
        productTypeDao.deleteById(id);
    }

    @Override
    public void modifyType(ProductTypeEntity type) {
        productTypeDao.saveAndFlush(type);
    }

    @Override
    public Page<ProductTypeEntity> getType(Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<ProductTypeEntity> specification = (Specification<ProductTypeEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return productTypeDao.findAll(specification, pageable);
    }

    @Override
    public List<ProductTypeEntity> getAll() {
        return productTypeDao.findAll();
    }

    @Override
    public ProductTypeEntity getOneType(Long id) {
        ProductTypeEntity productTypeEntity = productTypeDao.getOne(id);
        return productTypeEntity;
    }

    public Long count() {
        return productTypeDao.count();
    }
}
