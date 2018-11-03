package com.ypxx.manage.system.role.repository;

import com.ypxx.manage.common.base.BaseRepository;
import com.ypxx.manage.system.role.entity.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by xuwei on 2018/10/5.
 */
@Repository
public interface IRoleRepository extends BaseRepository<RoleEntity,Long> {
}
