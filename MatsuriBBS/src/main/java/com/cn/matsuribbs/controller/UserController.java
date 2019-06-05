package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.UserBiz;
import com.cn.matsuribbs.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserBiz userBiz;

    @GetMapping("api/login")
    public User Login(String userName, String password){
        User user = userBiz.login(userName, password);

        if(user == null){
            return null;
        }

        return user;
    }
    @GetMapping("api/register")
    public User Register(User user){
        boolean flag=userBiz.register(user);
        if(flag){
            return null;
        }
        return  user;
    }
}
