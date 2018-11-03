package com.ypxx.manage.system.role.entity;

import com.ypxx.manage.common.base.BaseEntity;
import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.user.entity.UserEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xuwei on 2018/10/4.
 */
@Entity
@Table(name = "tp_role")
public class RoleEntity extends BaseEntity {
    @Column(nullable = false)
    private String role;
    private String description;
    private Boolean available = Boolean.TRUE; // 是否可用,如果不可用将不会添加给用户
    //角色 -- 权限关系：多对多关系;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name="TpRolePermission",joinColumns={@JoinColumn(name="roleId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<PermissionEntity> permissions;
    // 用户 - 角色关系定义;
    @OneToMany(mappedBy = "role",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<UserEntity> users;// 一个角色对应多个用户

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
