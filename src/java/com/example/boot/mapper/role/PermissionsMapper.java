package com.example.boot.mapper.role;

import com.example.boot.model.role.Permissions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PermissionsMapper {
    Set<Permissions> getPermissionsByRole(@Param("roleId")Integer roleId);
}
