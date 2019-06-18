package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.ReplyBiz;
import com.cn.matsuribbs.entity.Reply;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return replyBiz.viewReplyByPostId(id,page,limit);
    }

    /**
     *  回复帖子(需要验证token)
     * @param reply  回复信息
     * @return
     */
    @PostMapping("api/reply")
    public Result addReply(@RequestBody Reply reply){
        return replyBiz.addReply(reply);
    }

    /**
     * 获取回复详情
     * @param id  回复id
     * @return
     */
    @GetMapping("api/reply/{id}")
    public Result viewReply(@PathVariable Integer id){
        return  replyBiz.viewReplyById(id);
    }

    /**
     *  删除回复,需由该回复所属用户或管理员删除(需要验证token)
     * @param id  回复id
     * @return
     */
    @DeleteMapping("api/reply/{id}")
    public Result deleteReply(@PathVariable Integer id){
        return replyBiz.deleteReplyById(id);
    }
}
