package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.ReplyBiz;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyController {

    @Autowired
    ReplyBiz replyBiz;

    /**
     * 按照回复时间排序 分页查看帖子下的回复
     * @param id  帖子id
     * @param page  页数
     * @param limit  每页获取数量
     * @return
     */
    @GetMapping("api/post/{id}/reply")
    public Result viewPostReply(@PathVariable Integer id, Integer page, Integer limit){
        return replyBiz.viewReplyByPostIdFun(id,page,limit);
    }

}
