package com.ypxx.manage.manage.product.dao;

import com.ypxx.manage.common.base.BaseRepository;
import com.ypxx.manage.manage.product.entity.ProductEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends BaseRepository<ProductEntity, Long> {
}
