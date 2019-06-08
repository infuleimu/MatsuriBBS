package com.cn.matsuribbs.biz;

import com.cn.matsuribbs.controller.UserController;
import com.cn.matsuribbs.entity.Post;
import com.cn.matsuribbs.entity.User;
import com.cn.matsuribbs.mapper.UserCollectionMapper;
import com.cn.matsuribbs.result.Result;
import com.cn.matsuribbs.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollectionBiz {
    @Autowired
    UserCollectionMapper userCollectionMapper;

    /**
     *  添加收藏
     * @param post 收藏的帖子
     * @param user 用于检查用户是否登录
     * @return
     */
    public Result addCollection(Post post, User user) {
        if(user.getUserName()!=null&&user.getUserName()==""){
            return ResultFactory.buildFailResult("添加收藏失败，请检查你是否登录");
        }
        try{
            userCollectionMapper.insertCollectionFun(post,user);
            return ResultFactory.buildSuccessResult("添加收藏成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("添加收藏失败");
        }
    }

    /**
     * 删除收藏
     * @param post 删除的帖子
     * @param user
     * @return
     */
    public Result delectCollection(Post post, User user) {
        try{
            userCollectionMapper.delectCollectionByIdFun(post,user);
            return ResultFactory.buildSuccessResult("添加收藏成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("添加收藏失败");
        }
    }

    public Result selectAllCollection() {
        try{
            userCollectionMapper.selectAllCollectionByIdFun();
            return ResultFactory.buildSuccessResult("添加收藏成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult("添加收藏失败");
        }
    }
}
