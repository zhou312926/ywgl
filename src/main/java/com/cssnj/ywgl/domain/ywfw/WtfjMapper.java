package com.cssnj.ywgl.domain.ywfw;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface WtfjMapper {
    long countByExample(WtfjCriteria example);

    int deleteByExample(WtfjCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Wtfj record);

    int insertSelective(Wtfj record);

    List<Wtfj> selectByExampleWithRowbounds(WtfjCriteria example, RowBounds rowBounds);

    List<Wtfj> selectByExample(WtfjCriteria example);

    Wtfj selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Wtfj record, @Param("example") WtfjCriteria example);

    int updateByExample(@Param("record") Wtfj record, @Param("example") WtfjCriteria example);

    int updateByPrimaryKeySelective(Wtfj record);

    int updateByPrimaryKey(Wtfj record);
}