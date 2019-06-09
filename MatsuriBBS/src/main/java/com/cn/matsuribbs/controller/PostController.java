package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.PostBiz;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    PostBiz postBiz;

    @GetMapping("api/post")
    public Result ViewAllPost(Integer page, Integer limit, Integer sid){
        return postBiz.viewPost(page, limit, sid);
    }

}
