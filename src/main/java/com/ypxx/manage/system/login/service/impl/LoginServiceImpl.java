package com.ypxx.manage.system.login.service.impl;

import com.ypxx.manage.manage.news.entity.EnterpriseEntity;
import com.ypxx.manage.system.login.service.ILoginService;
import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.permission.repository.IPermissionRepository;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.role.repository.IRoleRepository;
import com.ypxx.manage.system.user.entity.UserEntity;
import com.ypxx.manage.system.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xuwei on 2018/10/5.
 */
@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final IPermissionRepository permissionRepository;

    @Autowired
    public LoginServiceImpl(IUserRepository userRepository, IRoleRepository roleRepository, IPermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserEntity addUser(Map<String, Object> map) {
        UserEntity user = new UserEntity();
        user.setName(map.get("username").toString());
        user.setPassword(map.get("password").toString());
        userRepository.save(user);
        return user;
    }

    @Override
    public RoleEntity addRole(Map<String, Object> map) {
        UserEntity user = userRepository.findById(Long.valueOf(map.get("userId").toString())).get();
        RoleEntity role = new RoleEntity();
        role.setRole(map.get("roleName").toString());
        //role.setUser(user);
        PermissionEntity permission1 = new PermissionEntity();
        permission1.setPermission("create");
        //permission1.setRole(role);
        PermissionEntity permission2 = new PermissionEntity();
        permission2.setPermission("update");
        //permission2.setRole(role);
        List<PermissionEntity> permissions = new ArrayList<>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    @Override
    public UserEntity findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

}
