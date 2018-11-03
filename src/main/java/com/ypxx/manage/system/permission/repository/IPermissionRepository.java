package com.ypxx.manage.system.permission.repository;

import com.ypxx.manage.common.base.BaseRepository;
import com.ypxx.manage.system.permission.entity.PermissionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuwei on 2018/10/8.
 */
@Repository
public interface IPermissionRepository extends BaseRepository<PermissionEntity,Long> {

    @Query(value = "SELECT p.* FROM tp_permission p,(SELECT r.* FROM tp_role r RIGHT JOIN tp_user u ON u.role_id = r.id AND u.del = 0 WHERE r.del = 0 AND u.username = ?1) s,tp_role_permission k WHERE s.id = k.role_id AND p.id = k.permission_id AND s.del = 0 AND p.del = 0",nativeQuery = true)
    List<PermissionEntity> findPermissionListByUsername(String username);
}
