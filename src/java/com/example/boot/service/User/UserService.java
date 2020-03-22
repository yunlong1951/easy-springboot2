package com.example.boot.service.User;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.common.bean.JSONResult;
import com.example.boot.mapper.role.PermissionsMapper;
import com.example.boot.mapper.role.RoleMapper;
import com.example.boot.mapper.user.UserMapper;
import com.example.boot.model.role.Permissions;
import com.example.boot.model.role.Role;
import com.example.boot.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleList;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionsMapper permissionsMapper;

    public JSONObject login(String userName,String password){
        User user = userMapper.getUserByName(userName);

        //获取角色
        Set<Role> roleList = roleMapper.selectRoleByUser(user.getUserId());
        for (Role role :roleList){
            Set<Permissions> permissionsSet = permissionsMapper.getPermissionsByRole(role.getRoleId());
            role.setPermissions(permissionsSet);
        }
        user.setRoles(roleList);
        return JSONResult.callSuccess(user);
    }

    public User login(String userName){
        User user = userMapper.getUserByName(userName);

        //获取角色
        Set<Role> roleList = roleMapper.selectRoleByUser(user.getUserId());
        for (Role role :roleList){
            Set<Permissions> permissionsSet = permissionsMapper.getPermissionsByRole(role.getRoleId());
            role.setPermissions(permissionsSet);
        }
        user.setRoles(roleList);
        return user;
    }
}
