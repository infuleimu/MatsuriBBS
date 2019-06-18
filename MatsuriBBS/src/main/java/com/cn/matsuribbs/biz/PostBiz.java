package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.mapper.PostMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import com.cn.matsuribbs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostBiz {

    @Autowired
    PostMapper postMapper;


    public Result viewPost(Integer page, Integer limit, Integer id) {
        PageBean pageBean = new PageBean(page, limit , id);
        int total = postMapper.selectCountByPageFun(pageBean);
        List<Post> postList = postMapper.selectByPageFun(pageBean);
        Map map = new HashMap();
        map.put("total", total);
        map.put("page" , pageBean.getPage());
        map.put("list", postList);
        return ResultFactory.buildSuccessResult(map);
    }

    public Result viewPostByPostId(Integer id) {
        Post post = postMapper.selectByPostId(id);
        if (post != null){
            return ResultFactory.buildSuccessResult(post);
        } else {
            return ResultFactory.buildFailResult("获取帖子信息出错");
        }
    }

    public Result addPost(Post post) {
        try {
            postMapper.insertFun(post);
            return ResultFactory.buildSuccessResult("发帖成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("发帖失败");
        }
    }

    public Result AddGoodPost(Integer id) {
        try {
            postMapper.updateFun(id);
            return ResultFactory.buildSuccessResult("加精成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("加精失败");
        }
    }

    public Result DeletePost(Integer id) {
        try {
            postMapper.deleteFun(id);
            return ResultFactory.buildSuccessResult("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult("删除失败");
        }
    }
}
