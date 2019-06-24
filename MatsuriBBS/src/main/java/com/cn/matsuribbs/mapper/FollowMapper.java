package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.Follow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    void insertFun(Follow follow);

    Follow selectByIdFun(Integer id);

    void deleteFun(Integer id);

    List<Follow> selectByFollowerIdFun(Integer id);

    List<Follow> selectByUserIdFun(Integer id);
}
