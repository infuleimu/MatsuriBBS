package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.SubReplyBiz;
import com.cn.matsuribbs.entity.SubReply;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubReplyController {

    @Autowired
    SubReplyBiz subReplyBiz;

    /**
     * 分页查看楼中楼回复
     * @param page  页数
     * @param limit  每页显示数量
     * @param id  所属主回复id
     * @return
     */
    @GetMapping("api/reply/{id}/subreply")
    public Result viewSubReply(Integer page, Integer limit, @PathVariable Integer id){
        return subReplyBiz.viewSubReplyByReplyId(page, limit, id);
    }

    /**
     *  楼中楼回复接口(需要验证token)
     * @param subReply 楼中楼回复信息
     * @return
     */
    @PostMapping("api/subreply")
    public Result addSubReply(@RequestBody SubReply subReply){
        return subReplyBiz.addSubReply(subReply);
    }

    /**
     *  删除楼中楼回复,只能由回复者或管理员删除
     * @param id
     * @return
     */
    @DeleteMapping("api/subreply/{id}")
    public Result deleteSubReply(@PathVariable Integer id){
        return subReplyBiz.deleteSubReply(id);
    }
}
