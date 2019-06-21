package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.mapper.UserMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import com.cn.matsuribbs.util.Token;
import com.cn.matsuribbs.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserBiz {

    @Autowired
    UserMapper userMapper;

    /**
     * 验证邮箱和密码,派发token
     * @param email 邮箱
     * @param password 密码
     * @return
     */
    public Result login(String email, String password) {

        User user = userMapper.selectByEmail(email);

        if(user != null && user.getPassword().equals(password)){
            Token token = new Token();
            Map map = new HashMap<>();
            user.setPassword(null);    //用比较傻逼的操作让密码为空,防止前端获取到用户密码
            map.put("user", user);
            map.put("token", token.createTokenWithClaim(user.getUserName()));
            return ResultFactory.buildSuccessResult(map);    //用ResultFactory封装响应结果
        } else {
            return ResultFactory.buildFailResult("登录失败,用户名或密码不正确");
        }
    }

    /**
     * 注册功能
     * @param user 拿到用户的注册信息user
     * @return
     */
    public Result register(User user) {
        try {
            userMapper.insertFun(user);
            User u = userMapper.selectByEmail(user.getEmail());    //后台再从数据库查询拿出用户

            Token token = new Token();
            Map map = new HashMap<>();
            u.setPassword(null);    //用比较傻逼的操作让密码为空,防止前端获取到用户密码
            map.put("user", u);
            map.put("token", token.createTokenWithClaim(user.getUserName()));
            return ResultFactory.buildSuccessResult(map);
        }catch (Exception e){
            return ResultFactory.buildFailResult("注册失败,请检查您输入的信息");
        }
    }

    public Result modifyUserInfo(User user, MultipartFile avatar, HttpServletRequest req) {
        if(avatar.getSize() != 0){
            UploadUtil uploadUtil = new UploadUtil();
            String path = uploadUtil.upload(avatar, req);
            user.setAvatar(path);
        }
        try {
            userMapper.updateInfoFun(user);
            return ResultFactory.buildSuccessResult("修改个人信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("修改个人信息失败");
        }
    }

    public Result modifyUserPhone(User user) {
        try {
            userMapper.updatePhoneFun(user);
            return ResultFactory.buildSuccessResult("修改手机号成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("修改手机号失败");
        }
    }

    public Result modifyUserPassword(User user) {
        try {
            userMapper.updatePasswordFun(user);
            return ResultFactory.buildSuccessResult("修改密码成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("修改密码失败");
        }
    }

    public Result checkOldPassword(Integer id, String password) {
        User checkUser = userMapper.selectByID(id);
        if(checkUser != null && checkUser.getPassword().equals(password)){
            return ResultFactory.buildSuccessResult("验证旧密码成功");
        } else {
            return ResultFactory.buildSuccessResult("验证旧密码失败");
        }
    }
}
