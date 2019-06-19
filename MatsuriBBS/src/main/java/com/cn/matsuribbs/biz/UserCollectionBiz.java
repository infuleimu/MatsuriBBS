package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.controller.UserController;
import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.entity.UserCollection;
import com.cn.matsuribbs.mapper.UserCollectionMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import com.cn.matsuribbs.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCollectionBiz {

    @Autowired
    UserCollectionMapper userCollectionMapper;

    public Result addCollection(UserCollection userCollection) {
        try{
            userCollectionMapper.insertFun(userCollection);
            return ResultFactory.buildSuccessResult("收藏成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("收藏失败");
        }
    }

    public Result deleteCollection(Integer id) {
        try{
            UserCollection userCollection = userCollectionMapper.selectByIdFun(id);
            if (userCollection != null){
                userCollectionMapper.deleteFun(id);
                return ResultFactory.buildSuccessResult("删除收藏成功");
            } else {
                return ResultFactory.buildFailResult("删除收藏失败,未找到对应收藏");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("删除收藏失败");
        }
    }

    public Result viewCollectionByUserId(Integer page, Integer limit, Integer uid) {
        PageBean pageBean = new PageBean(page,limit,uid);
        int total = userCollectionMapper.selectCountByUserId(uid);
        List<Post> collectionList = userCollectionMapper.selectByUserIdFun(pageBean);
        Map map = new HashMap();
        map.put("total", total);
        map.put("page" , pageBean.getPage());
        map.put("list", collectionList);
        if (collectionList != null){
            return ResultFactory.buildSuccessResult(map);
        } else {
            return ResultFactory.buildFailResult("获取信息失败");
        }
    }
}
