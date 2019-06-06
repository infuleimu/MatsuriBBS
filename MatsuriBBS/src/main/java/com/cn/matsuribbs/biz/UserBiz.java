package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.mapper.UserMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {

    @Autowired
    UserMapper userMapper;
    public Result login(String account, String password) {

        User user;
        //验证是否使用邮箱登录
        if(account.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")){
            user = userMapper.selectByEmail(account);
        } else {
            user = userMapper.selectByPhone(account);
        }

        if(user != null && user.getPassword().equals(password)){
            return ResultFactory.buildSuccessResult(user);
        } else {
            return ResultFactory.buildFailResult("登录失败,用户名或密码不正确");
        }
    }

    /**
     * 注册功能
     * @param user 拿到注册信息user
     * @return
     */
    public Result register(User user) {
//        boolean flag = UserMapper.insertFun(user);
//        if(flag){
//            return ResultFactory.buildSuccessResult(flag);
//        }else {
//            return ResultFactory.buildFailResult("注册失败,请检查您输入的信息");
//        }
        return  null;
    }
}
