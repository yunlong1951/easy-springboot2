package com.example.boot.mapper.role;

import com.example.boot.model.role.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleMapper {
    //获取用户的角色
    Set<Role> selectRoleByUser(@Param("userId")Integer userId);
}
