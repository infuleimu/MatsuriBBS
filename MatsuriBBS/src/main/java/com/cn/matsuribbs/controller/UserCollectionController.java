package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.UserCollectionBiz;
import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.entity.UserCollection;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserCollectionController {

    @Autowired
    UserCollectionBiz userCollectionBiz;

    /**
     *  添加收藏(需要验证token)
     * @param userCollection 收藏信息,内含pid:帖子id、userId:用户id
     * @return
     */
    @PostMapping("api/user_collection")
    public Result addCollection(@RequestBody UserCollection userCollection){
        return userCollectionBiz.addCollection(userCollection);
    }

    /**
     * 删除收藏(验证token)
     * @param id
     * @return
     */
    @DeleteMapping("api/user_collection/{id}")
    public Result deleteCollection(@PathVariable Integer id){
        return userCollectionBiz.deleteCollection(id);
    }

    /**
     * 查看收藏
     * @param id  用户id
     * @return
     */
    @GetMapping("api/user_collection")
    public Result viewCollection(Integer page, Integer limit, Integer uid){
        return userCollectionBiz.viewCollectionByUserId(page,limit,uid);
    }

}
