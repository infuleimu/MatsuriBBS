package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.Reply;
import com.cn.matsuribbs.mapper.ReplyMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import com.cn.matsuribbs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReplyBiz {

    @Autowired
    ReplyMapper replyMapper;

    public Result viewReplyByPostId(Integer id, Integer page, Integer limit){
        PageBean pageBean = new PageBean(page, limit , id);
        int total = replyMapper.selectCountByPageFun(pageBean);
        List<Reply> replyList = replyMapper.selectByPostIDFun(pageBean);
        Map map = new HashMap();
        map.put("pid", id);
        map.put("total", total);
        map.put("page" , pageBean.getPage());
        map.put("list", replyList);
        if (replyList != null){
            return ResultFactory.buildSuccessResult(map);
        } else {
            return ResultFactory.buildFailResult("获取信息失败");
        }
    }

    public Result viewReplyById(Integer id) {
        Reply reply = replyMapper.selectByIDFun(id);
        if(reply != null){
            return ResultFactory.buildSuccessResult(reply);
        } else {
            return ResultFactory.buildFailResult("获取信息失败");
        }
    }

    public Result deleteReplyById(Integer id) {
        try {
            Reply reply = replyMapper.selectByIDFun(id);
            if(reply != null){
                replyMapper.deleteFun(id);
                return ResultFactory.buildSuccessResult("删除成功");
            } else {
                return ResultFactory.buildFailResult("删除失败,未找到相应回复");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("删除失败");
        }
    }

    public Result addReply(Reply reply) {
        try {
            replyMapper.insertFun(reply);
            return ResultFactory.buildSuccessResult("回复成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("回复失败");
        }
    }
}
