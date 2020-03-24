package com.example.boot.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.common.bean.JSONResult;
import com.example.boot.common.utils.Constants;
import com.example.boot.common.utils.RedisUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    RedisUtil redisUtil;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequiresPermissions("redis.all")
    @GetMapping(value = "/getRedis")
    public JSONObject getRedis(){
//        redisUtil.set("20182018","这是一条测试数据", Constants.REDIS_DATABASE1);
//        Long resExpire = redisUtil.expire("20182018", Constants.REDIS_TIME_OUT, Constants.REDIS_DATABASE1);//设置key过期时间
//        logger.info("resExpire="+resExpire);
        String res = redisUtil.get("20182018", Constants.REDIS_DATABASE1);
        return JSONResult.callSuccess(res);
    }
}
