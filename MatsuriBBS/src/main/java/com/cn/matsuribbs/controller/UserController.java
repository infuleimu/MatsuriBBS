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

    /**
     * 修改个人信息(需要验证token)
     * @param user  用户信息
     * @return
     */
    @PutMapping("api/user/info")
    public Result modifyUserInfo(@RequestBody User user){
        return userBiz.modifyUserInfo(user);
    }

    /**
     * 修改手机号(需要验证token)
     * @param user 用户信息
     * @return
     */
    @PutMapping("api/user/phone")
    public Result modifyUserPhone(@RequestBody User user){
        return userBiz.modifyUserPhone(user);
    }

    /**
     * 修改密码前,验证旧密码
     * @param user
     * @return
     */
    @GetMapping("api/user/password")
    public Result beforeModifyPassword(Integer id, String password){
        return userBiz.checkOldPassword(id,password);
    }

    /**
     * 修改密码(需要验证token)
     * @param user 用户信息
     * @return
     */
    @PutMapping("api/user/password")
    public Result modifyUserPassword(@RequestBody User user){
        return userBiz.modifyUserPassword(user);
    }
}
