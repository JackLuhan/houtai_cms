package com.ypxx.manage.system.role.service;

import com.ypxx.manage.system.role.entity.RoleEntity;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by xuwei on 2018/10/6.
 */
public interface IRoleService {
    /**
     * 角色列表
     */
    List<RoleEntity> list();

    /**
     * 通过id获取角色
     */
    RoleEntity findRoleById(Long roleId);

    /**
     * 角色列表
     */
    Page<RoleEntity> roleList(Integer pageNum, Integer pageSize, String name, Date startTime, Date endTime);

    /**
     * 添加角色
     */
    RoleEntity add(String name, Long[] typeId, Long[] permId, String desc);

    /**
     * 删除角色
     */
    RoleEntity delete(Long id);

    /**
     * 更新角色
     */
    RoleEntity update(Long id, String name, Long[] typeId, Long[] permId, String desc);
}
