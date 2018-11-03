package com.ypxx.manage.common.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by xuwei on 2018/10/5.
 */
@NoRepositoryBean
public interface BaseRepository <T,I extends Serializable> extends PagingAndSortingRepository<T,I>, JpaSpecificationExecutor<T>, JpaRepository<T,I> {
}
