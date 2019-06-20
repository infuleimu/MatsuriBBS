package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    void insertFun(User user);

    User selectByEmail(String email);

    void updateInfoFun(User user);

    void updatePhoneFun(User user);

    void updatePasswordFun(User user);

    User selectByID(Integer id);
}
