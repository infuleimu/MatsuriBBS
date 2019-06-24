package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.SubSection;
import com.cn.matsuribbs.mapper.SubSectionMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSectionBiz {

    @Autowired
    SubSectionMapper subSectionMapper;

    public Result viewSubSectionByMainSectionId(Integer id) {
        List<SubSection> subSectionList = subSectionMapper.selectByMid(id);
        if(subSectionList != null){
            return ResultFactory.buildSuccessResult(subSectionList);
        } else {
            return ResultFactory.buildFailResult("获取信息失败");
        }
    }
}
