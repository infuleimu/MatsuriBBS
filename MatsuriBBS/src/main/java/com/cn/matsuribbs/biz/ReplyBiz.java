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

    public Result viewReplyByPostIdFun(Integer id, Integer page, Integer limit){
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

}
