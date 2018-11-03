package com.ypxx.manage.common.utils;

import com.ypxx.manage.system.user.entity.UserEntity;
import org.apache.shiro.SecurityUtils;


/**
 * Created by xuwei on 2018/10/6.
 */
public class UserUtils {
    /**
     * 获取当前用户
     */
    public static UserEntity getUser(){
        return (UserEntity) SecurityUtils.getSubject().getPrincipal();
    }

}
