package com.ypxx.manage.manage.product.service.impl;

import com.ypxx.manage.manage.product.dao.ProductDao;
import com.ypxx.manage.manage.product.entity.ProductEntity;
import com.ypxx.manage.manage.product.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProduct(ProductEntity product) {
        productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public void modifyProduct(ProductEntity product) {
        productDao.saveAndFlush(product);
    }

    @Override
    public Page<ProductEntity> getProduct(Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<ProductEntity> specification = (Specification<ProductEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return productDao.findAll(specification, pageable);
    }

    @Override
    public Page<ProductEntity> seachProduct(Integer pageNum, Integer pageSize, Long typeid, String seachtext) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);
        Specification<ProductEntity> specification = (Specification<ProductEntity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seachtext != null && !"".equals(seachtext)) {
                predicates.add(criteriaBuilder.like(root.get("productName"), "%" + seachtext + "%"));
            }

            if (typeid != null) {
                predicates.add(criteriaBuilder.equal(root.get("productTypeID"), typeid));
            }

            predicates.add(criteriaBuilder.equal(root.get("del"), 0));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return productDao.findAll(specification, pageable);
    }

    @Override
    public List<ProductEntity> getAll() {

        List<ProductEntity> list = productDao.findAll();
        return list;
    }

    @Override
    public ProductEntity getOneProduct(Long id) {
        ProductEntity product = productDao.getOne(id);
        return product;
    }

    @Override
    public Long count() {
        return productDao.count();
    }

}
