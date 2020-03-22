package com.example.boot.common.base;

import com.alibaba.fastjson.JSONObject;
import com.example.boot.common.bean.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class BaseController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/un_auth")
    public void SignFail(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.append(JSONResult.callSignFail(null).toString());
        response.setStatus(403);
    }

    @RequestMapping("/unauthorized")
    public void InvalidRequest(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.append(JSONResult.callInvalidRequest(request.getRequestURI()).toString());
        response.setStatus(403);
    }

    
}
