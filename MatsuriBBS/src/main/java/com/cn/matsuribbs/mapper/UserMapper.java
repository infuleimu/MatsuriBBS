package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectByUserName(String userName);
}
