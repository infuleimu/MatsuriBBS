package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.FollowBiz;
import com.cn.matsuribbs.entity.Follow;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FollowController {

    @Autowired
    FollowBiz followBiz;

    /**
     * 关注用户(需要验证token)
     * @param follow 关注信息,关注者ID,被关注者ID
     * @return
     */
    @PostMapping("api/follow")
    public Result follow(@RequestBody Follow follow){
        return followBiz.followUser(follow);
    }

    /**
     * 取消关注
     * @param id  关注主键ID
     * @return
     */
    @DeleteMapping("api/follow/{id}")
    public Result unFollow(@PathVariable Integer id){
        return followBiz.unFollowUser(id);
    }
}
