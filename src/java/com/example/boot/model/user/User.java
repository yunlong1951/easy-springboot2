package com.example.boot.model.user;

import com.example.boot.common.base.BaseModel;
import com.example.boot.model.role.Role;

import java.util.Set;

public class User extends BaseModel {
    private Integer userId;
    private String userName;
    private String password;
    private Set<Role> roles;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
