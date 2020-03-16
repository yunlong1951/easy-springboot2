package com.example.boot.common.model.role;

import com.example.boot.common.base.BaseModel;

public class Permissions extends BaseModel {
    private String id;
    private String permissionsName;

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
