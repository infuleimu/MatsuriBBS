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

    @GetMapping("api/post/{id}/reply")
    public Result ViewPostReply(@PathVariable Integer id, Integer page, Integer limit){
        return replyBiz.viewReplyByPostIdFun(id,page,limit);
    }

}
