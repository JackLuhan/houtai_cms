package com.ypxx.manage.system.user.entity;

import com.ypxx.manage.common.base.BaseEntity;
import com.ypxx.manage.system.role.entity.RoleEntity;

import javax.persistence.*;

/**
 * Created by xuwei on 2018/10/4.
 */
@Entity
@Table(name = "tp_user")
public class UserEntity extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private String phone;
    private String email;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="role_id")
    private RoleEntity role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
