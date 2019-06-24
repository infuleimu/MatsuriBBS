package com.cn.matsuribbs.mapper;

import com.cn.matsuribbs.entity.SubSection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubSectionMapper {

    List<SubSection> selectByMid(Integer id);
}
