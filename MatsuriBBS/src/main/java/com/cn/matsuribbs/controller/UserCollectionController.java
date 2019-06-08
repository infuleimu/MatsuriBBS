package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.UserCollectionBiz;
import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.result.Result;
import org.springframework.web.bind.annotation.GetMapping;

public class UserCollectionController {
    UserCollectionBiz userCollectionBiz;
    @GetMapping("api/addCollection")
    public Result addCollection(Post post, User user){
        return userCollectionBiz.addCollection(post,user);
    }
    @GetMapping("api/delectCollection")
    public Result delectCollection(Post post,User user){
        return userCollectionBiz.delectCollection(post,user);
    }

    @GetMapping("api/selectAllCollection")
    public Result selectAllCollection(){
        return userCollectionBiz.selectAllCollection();
    }

}
