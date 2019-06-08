package com.cn.matsuribbs.util;

import com.alibaba.fastjson.JSON;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class TokenInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("access_token");
        //验证token是否存在
        if(token != null){
            boolean flag = Token.verifyToken(token);
            if (flag){
                return true;
            }
        }
        Result result = ResultFactory.buildPermissionFailResult("用户未登录");
        String jsonString = JSON.toJSONString(result);
        response.getWriter().write(jsonString);
        return false;
    }

}
