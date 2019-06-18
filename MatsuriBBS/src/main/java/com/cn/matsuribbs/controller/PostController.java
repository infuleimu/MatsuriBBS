package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.PostBiz;
import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    PostBiz postBiz;

    /**
     * 按照回复时间>发帖时间 查看帖子
     * @param page  分页
     * @param limit  每页获取数据数量
     * @param id  sid所属版块id,为空时显示所有版块帖子
     * @return
     */
    @GetMapping("api/post")
    public Result ViewAllPost(Integer page, Integer limit, Integer id) {
        return postBiz.viewPost(page, limit, id);
    }

    /**
     * 查看帖子详情
     * @param id  帖子id
     * @return
     */
    @GetMapping("api/post/{id}")
    public Result ViewPost(@PathVariable Integer id){
        return postBiz.viewPostByPostId(id);
    }

    /**
     * 发帖
     * @param post  帖子信息
     * @return
     */
    @PostMapping("api/post")
    public Result Post(@RequestBody Post post){
        return postBiz.addPost(post);
    }
}
