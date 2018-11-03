package com.ypxx.manage.system.login.service;

import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.user.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2018/10/5.
 */
public interface ILoginService {

    /**
     * 添加用户
     * @param map
     * @return
     */
    UserEntity addUser(Map<String, Object> map);

    /**
     * 添加角色
     * @param map
     * @return
     */
    RoleEntity addRole(Map<String, Object> map);

    /**
     * 查询用户通过用户名
     * @param name
     * @return
     */
    UserEntity findByUsername(String name);

}
