package com.cssnj.ywgl.domain.ywdm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface YyxtMapper {
    int countByExample(YyxtCriteria example);

    int deleteByPrimaryKey(String dm);

    int insert(Yyxt record);

    int insertSelective(Yyxt record);

    List<Yyxt> selectByExampleWithRowbounds(YyxtCriteria example, RowBounds rowBounds);

    List<Yyxt> selectByExample(YyxtCriteria example);

    Yyxt selectByPrimaryKey(String dm);

    int updateByPrimaryKeySelective(Yyxt record);

    int updateByPrimaryKey(Yyxt record);

    List<Yyxt> selectAll();
}