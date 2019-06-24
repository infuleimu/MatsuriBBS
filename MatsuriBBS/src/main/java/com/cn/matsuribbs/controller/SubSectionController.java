package com.cn.matsuribbs.controller;

import com.cn.matsuribbs.biz.SubSectionBiz;
import com.cn.matsuribbs.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubSectionController {

    @Autowired
    SubSectionBiz subSectionBiz;

    @GetMapping("api/main_section/{id}/sub_section")
    public Result viewSubSection(@PathVariable Integer id){
        return subSectionBiz.viewSubSectionByMainSectionId(id);
    }

}
