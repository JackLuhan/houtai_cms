package com.ypxx.manage.system.permission.entity;

import com.ypxx.manage.common.base.BaseEntity;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.type.entity.TypeEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xuwei on 2018/10/5.
 */
@Entity
@Table(name = "tp_permission")
public class PermissionEntity extends BaseEntity {

    private String name;
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button];
    private String url;         //资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private Long parentId;      //父编号
    private String parentIds;   //父编号列表
    private Boolean available = Boolean.TRUE;
    @ManyToMany
    @JoinTable(name="TpRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<RoleEntity> roles;
    @ManyToMany
    @JoinTable(name="TpPermissionType",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="typeId")})
    private List<TypeEntity> types;

    public List<TypeEntity> getTypes() {
        return types;
    }

    public void setTypes(List<TypeEntity> types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
