package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.util.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> selectAllFun();

    List<Post> selectByPageFun(PageBean pageBean);

    int selectCountByPageFun(PageBean pageBean);

    Post selectByPostId(Integer id);

    void insertFun(Post post);
}
