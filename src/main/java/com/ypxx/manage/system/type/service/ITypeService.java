package com.ypxx.manage.system.type.service;

import com.ypxx.manage.system.type.entity.TypeEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by xuwei on 2018/10/8.
 */
public interface ITypeService {
    /**
     * 添加权限分类
     */
    TypeEntity add(String name);

    /**
     * 分页查询
     */
    Page<TypeEntity> page(Integer pageNum, Integer pageSize);

    /**
     * 删除分类
     */
    TypeEntity delete(Long id);

    /**
     * 获取全部分类
     */
    List<TypeEntity> list();
    /**
     * 根据id查询
     */
    TypeEntity findOne(Long id);

    /**
     * 编辑
     */
    TypeEntity edit(TypeEntity type);
}
