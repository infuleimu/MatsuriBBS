package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.SubReply;
import com.cn.matsuribbs.mapper.SubReplyMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import com.cn.matsuribbs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubReplyBiz {

    @Autowired
    SubReplyMapper subReplyMapper;

    public Result viewSubReplyByReplyId(Integer page, Integer limit, Integer id) {
        PageBean pageBean = new PageBean(page,limit,id);
        int total = subReplyMapper.selectCountByPageFun(pageBean);
        List<SubReply> subReplyList = subReplyMapper.selectByReplyIdFun(pageBean);
        Map map = new HashMap();
        map.put("pid", id);
        map.put("total", total);
        map.put("page" , pageBean.getPage());
        map.put("list", subReplyList);
        if (subReplyList != null){
            return ResultFactory.buildSuccessResult(map);
        } else {
            return ResultFactory.buildFailResult("获取信息失败");
        }
    }

    public Result addSubReply(SubReply subReply) {
        try {
            subReplyMapper.insertFun(subReply);
            return ResultFactory.buildSuccessResult("回复成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("回复失败");
        }
    }

    public Result deleteSubReply(Integer id) {
        try {
            SubReply subReply = subReplyMapper.selectByIDFun(id);
            if(subReply != null){
                subReplyMapper.deleteFun(id);
                return ResultFactory.buildSuccessResult("删除成功");
            } else {
                return ResultFactory.buildFailResult("删除失败,未找到相应回复");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("删除失败");
        }
    }
}
