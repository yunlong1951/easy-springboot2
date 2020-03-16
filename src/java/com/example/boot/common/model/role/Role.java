package com.example.boot.common.model.role;

import com.example.boot.common.base.BaseModel;

import java.util.Set;

public class Role extends BaseModel {
    private String id;
    private String roleName;
    private Set<Permissions> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }
}
