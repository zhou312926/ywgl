package com.cssnj.ywgl.domain.xtdm;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CzlxMapper {
    int deleteByPrimaryKey(String dm);

    int insert(Czlx record);

    int insertSelective(Czlx record);

    Czlx selectByPrimaryKey(String dm);

    int updateByPrimaryKeySelective(Czlx record);

    int updateByPrimaryKey(Czlx record);
}