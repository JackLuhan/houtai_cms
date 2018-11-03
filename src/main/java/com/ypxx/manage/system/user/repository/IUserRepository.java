package com.ypxx.manage.system.user.repository;

import com.ypxx.manage.common.base.BaseRepository;
import com.ypxx.manage.system.user.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by xuwei on 2018/10/5.
 */
@Repository
public interface IUserRepository extends BaseRepository<UserEntity, Long> {

    UserEntity findByUsername(String name);
}
