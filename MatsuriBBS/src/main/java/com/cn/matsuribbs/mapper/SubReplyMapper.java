package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.SubReply;
import com.cn.matsuribbs.util.PageBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubReplyMapper {

    int selectCountByPageFun(PageBean pageBean);

    List<SubReply> selectByReplyIdFun(PageBean pageBean);

    void insertFun(SubReply subReply);

    SubReply selectByIDFun(Integer id);

    void deleteFun(Integer id);
}
