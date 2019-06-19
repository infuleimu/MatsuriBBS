package com.cn.matsuribbs.util;


import com.alibaba.fastjson.JSON;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UrlFilter01", urlPatterns = {"/api/post","/api/post/*","/api/reply","/api/reply/*","/api/subreply","/api/subreply/*","/api/user_collection","/api/user_collection/*","/api/follow","/api/follow/*"})
public class UrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String method = req.getMethod();
        String token = req.getHeader("access_token");
        //判断是否为新增、修改、删除请求,获取token判断用户身份
        if(method.equals("POST") || method.equals("PUT") || method.equals("DELETE")){
            //判断token是否为空
            if(token != null){
                //验证token
                boolean flag = Token.verifyToken(token);
                if (!flag){
                    Result result = ResultFactory.buildPermissionFailResult("token错误或已过期");
                    String jsonString = JSON.toJSONString(result);
                    servletResponse.getWriter().write(jsonString);
                } else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            } else {
                Result result = ResultFactory.buildPermissionFailResult("用户未登录");
                String jsonString = JSON.toJSONString(result);
                servletResponse.getWriter().write(jsonString);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
