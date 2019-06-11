package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCollectionMapper {


    void insertCollectionFun(Post post, User user);

    void selectAllCollectionByIdFun();

    void delectCollectionByIdFun(Post post, User user);
}
