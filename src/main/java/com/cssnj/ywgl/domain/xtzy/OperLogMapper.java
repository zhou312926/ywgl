package com.cssnj.ywgl.domain.xtzy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface OperLogMapper {
    long countByExample(OperLogCriteria example);

    int deleteByExample(OperLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(OperLog record);

    int insertSelective(OperLog record);

    List<OperLog> selectByExampleWithRowbounds(OperLogCriteria example, RowBounds rowBounds);

    List<OperLog> selectByExample(OperLogCriteria example);

    OperLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OperLog record, @Param("example") OperLogCriteria example);

    int updateByExample(@Param("record") OperLog record, @Param("example") OperLogCriteria example);

    int updateByPrimaryKeySelective(OperLog record);

    int updateByPrimaryKey(OperLog record);
}