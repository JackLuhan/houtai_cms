package com.ypxx.manage.system.permission.service;

import com.ypxx.manage.system.permission.entity.PermissionEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by xuwei on 2018/10/8.
 */
public interface IPermissionService {
    /**
     * 权限列表
     */
    Page<PermissionEntity> permissionList(Integer pageNum, Integer pageSize);

    /**
     * 添加权限
     */
    PermissionEntity add(Long typeId, String url, String name);

    /**
     * 通过id查询
     */
    PermissionEntity findById(Long aLong);

    /**
     * 级联查询，权限校验
     */
    List<PermissionEntity> findPermissionListByUsername(String username);

    /**
     * 修改权限管理
     */
    PermissionEntity edit(PermissionEntity permission,Long typeId);

    /**
     * 删除权限分类
     * @param id
     * @return
     */
    PermissionEntity del(Long id);
}
