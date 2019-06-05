package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.UserBiz;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserBiz userBiz;

    @GetMapping("api/login")
    public Result Login(String account, String password){
        return userBiz.login(account, password);
    }

}
