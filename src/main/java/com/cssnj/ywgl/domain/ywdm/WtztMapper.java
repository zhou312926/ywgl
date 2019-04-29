package com.cssnj.ywgl.domain.ywdm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface WtztMapper {
    int countByExample(WtztCriteria example);

    int deleteByPrimaryKey(String dm);

    int insert(Wtzt record);

    int insertSelective(Wtzt record);

    List<Wtzt> selectByExampleWithRowbounds(WtztCriteria example, RowBounds rowBounds);

    List<Wtzt> selectByExample(WtztCriteria example);

    Wtzt selectByPrimaryKey(String dm);

    int updateByPrimaryKeySelective(Wtzt record);

    int updateByPrimaryKey(Wtzt record);

    List<Wtzt> selectAll();
}