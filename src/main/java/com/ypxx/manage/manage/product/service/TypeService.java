package com.ypxx.manage.manage.product.service;

import com.ypxx.manage.manage.product.entity.ProductTypeEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TypeService {
    void addType(ProductTypeEntity type);

    void deleteType(Long id);

    void modifyType(ProductTypeEntity type);

     Page<ProductTypeEntity> getType(Integer pageNum, Integer pageSize);

     List<ProductTypeEntity> getAll();
    ProductTypeEntity getOneType(Long id);

    public Long count();
}
