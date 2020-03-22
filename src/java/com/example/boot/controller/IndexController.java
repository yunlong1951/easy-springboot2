package com.example.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.common.base.BaseController;
import com.example.boot.service.User.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;
    @GetMapping
    public JSONObject test(){
        JSONObject json = new JSONObject();
        json.put("in","in");
        return json;
    }

    @RequiresPermissions("ddl")
    @GetMapping("/test")
    public JSONObject index(){
        JSONObject json = new JSONObject();
        json.put("in","in");
        return json;
    }
    @RequiresPermissions("add")
    @GetMapping("/login")
    public JSONObject login(String username,String password){
        return  userService.login(username,password);
    }
}
