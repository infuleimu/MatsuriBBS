package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {

    @Autowired
    UserMapper userMapper;

    public User login(String userName, String password) {
        User user = userMapper.selectByUserName(userName);

        if(user != null && user.getPassword().equals(password)){
            return user;
        } else {
          return null;
        }
    }
}
