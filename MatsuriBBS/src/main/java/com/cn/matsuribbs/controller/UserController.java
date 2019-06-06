package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.UserBiz;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserBiz userBiz;

    /**
     * 用户或管理员登录
     * @param account  用户名或邮箱
     * @param password  密码
     * @return
     */
    @GetMapping("api/login")
    public Result Login(String account, String password){
        return userBiz.login(account, password);
    }
    @GetMapping("api/register")
    public Result Register(User user) {
        return userBiz.register(user);
    }
}
