package com.cssnj.ywgl.domain.xtdm;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ZhlxMapper {
    int deleteByPrimaryKey(String dm);

    int insert(Zhlx record);

    int insertSelective(Zhlx record);

    Zhlx selectByPrimaryKey(String dm);

    int updateByPrimaryKeySelective(Zhlx record);

    int updateByPrimaryKey(Zhlx record);
}