package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.UserBiz;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.result.Result;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserBiz userBiz;

    /**
     * 用户或管理员登录
     * @param email  邮箱
     * @param password  密码
     * @return
     */
    @GetMapping("api/login")
    public Result login(String email, String password){
        return userBiz.login(email, password);
    }

    /**
     * 邮箱注册
     * @param user 用户信息
     * @return
     */
    @PostMapping("api/register")
    public Result register(@RequestBody User user) {
        return userBiz.register(user);
    }
}
