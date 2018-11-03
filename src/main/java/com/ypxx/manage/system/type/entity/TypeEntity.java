package com.ypxx.manage.system.type.entity;

import com.ypxx.manage.common.base.BaseEntity;
import com.ypxx.manage.system.permission.entity.PermissionEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xuwei on 2018/10/5.
 */
@Entity
@Table(name = "tp_type")
public class TypeEntity extends BaseEntity {

    @Column(unique = true)
    private String name;
    @ManyToMany
    @JoinTable(name="TpPermissionType",joinColumns={@JoinColumn(name="typeId")},inverseJoinColumns={@JoinColumn(name="permissionId")})
    private List<PermissionEntity> permissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
