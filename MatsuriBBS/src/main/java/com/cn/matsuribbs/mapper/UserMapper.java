package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    void insertFun(User user);

    User selectByUserName(String account);

    User selectByEmail(String account);

    User selectByPhone(String account);
}
