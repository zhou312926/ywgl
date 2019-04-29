package com.cssnj.ywgl.domain.ywdm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface YwmkMapper {
    int countByExample(YwmkCriteria example);

    int deleteByPrimaryKey(String dm);

    int insert(Ywmk record);

    int insertSelective(Ywmk record);

    List<Ywmk> selectByExampleWithRowbounds(YwmkCriteria example, RowBounds rowBounds);

    List<Ywmk> selectByExample(YwmkCriteria example);

    Ywmk selectByPrimaryKey(String dm);

    int updateByPrimaryKeySelective(Ywmk record);

    int updateByPrimaryKey(Ywmk record);

    List<Ywmk> selectAll(String yyxtDm);
}