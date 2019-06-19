package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.Follow;
import com.cn.matsuribbs.mapper.FollowMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowBiz {

    @Autowired
    FollowMapper followMapper;

    public Result followUser(Follow follow) {
        try {
            followMapper.insertFun(follow);
            return ResultFactory.buildSuccessResult("关注成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("关注失败");
        }
    }

    public Result unFollowUser(Integer id) {
        try {
            Follow follow = followMapper.selectByIdFun(id);
            if(follow != null){
                followMapper.deleteFun(id);
                return ResultFactory.buildSuccessResult("取消关注成功");
            } else {
                return ResultFactory.buildFailResult("取消关注失败,找不到对应关注信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("取消关注失败");
        }
    }
}
