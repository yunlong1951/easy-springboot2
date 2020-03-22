package com.example.boot.mapper.user;

import com.example.boot.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByName(@Param("userName")String userName);
}
