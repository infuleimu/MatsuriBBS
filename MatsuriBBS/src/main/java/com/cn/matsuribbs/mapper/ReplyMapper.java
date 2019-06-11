package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.Reply;
import com.cn.matsuribbs.util.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {

    List<Reply> selectByPostIDFun(PageBean pageBean);

    int selectCountByPageFun(PageBean pageBean);
}
