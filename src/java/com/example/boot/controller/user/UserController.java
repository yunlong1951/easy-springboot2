package com.example.boot.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.common.bean.JSONResult;
import com.example.boot.model.user.User;
import com.example.boot.service.User.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public JSONObject login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                username,
                password
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
            String token = subject.getSession().getId().toString();
            log.info(token);
            return JSONResult.callSuccess(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return JSONResult.callFail( "账号不存在!");
        }  catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return JSONResult.callFail("密码不正确!");
        }catch (AuthenticationException e) {
            e.printStackTrace();
            return JSONResult.callSignFail(null);
        }
    }
}
