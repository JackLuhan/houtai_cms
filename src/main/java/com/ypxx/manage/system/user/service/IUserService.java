package com.ypxx.manage.system.user.service;

import com.ypxx.manage.system.user.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by xuwei on 2018/10/5.
 */
public interface IUserService {
    /**
     * 添加用户
     */
    UserEntity addUser(UserEntity user,Long roleIds);

    /**
     * 用户列表
     */
    Page<UserEntity> page(Integer pageNum, Integer pageSize, String name, Date start, Date end);

    /**
     * 删除用户
     */
    UserEntity delete(Long id);

    /**
     * 获取用户
     */
    UserEntity findById(Long id);

    /**
     * 用户列表
     */
    List<UserEntity> list();

    /**
     * 更新用户
     */
    UserEntity update(UserEntity user, Long roleId);
}
