package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.entity.UserCollection;
import com.cn.matsuribbs.util.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCollectionMapper {

    void insertFun(UserCollection userCollection);

    UserCollection selectByIdFun(Integer id);

    void deleteFun(Integer id);

    int selectCountByUserId(Integer uid);

    List<Post> selectByUserIdFun(PageBean pageBean);
}
