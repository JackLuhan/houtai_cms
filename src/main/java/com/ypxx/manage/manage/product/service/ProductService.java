package com.ypxx.manage.manage.product.service;

import com.ypxx.manage.manage.product.entity.ProductEntity;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductService {

    void addProduct(ProductEntity product);

    void deleteProduct(Long id);

    void modifyProduct(ProductEntity product);

    Page<ProductEntity> getProduct(Integer pageNum, Integer pageSize);

    Page<ProductEntity> seachProduct(Integer pageNum, Integer pageSize,Long typeid,String seachtext);

    List<ProductEntity> getAll();

    ProductEntity getOneProduct(Long id);

    public Long count();
}
