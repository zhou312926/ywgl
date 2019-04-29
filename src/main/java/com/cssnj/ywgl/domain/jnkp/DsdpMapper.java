package com.cssnj.ywgl.domain.jnkp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface DsdpMapper {
    long countByExample(DsdpCriteria example);

    int deleteByExample(DsdpCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Dsdp record);

    int insertSelective(Dsdp record);

    List<Dsdp> selectByExampleWithRowbounds(DsdpCriteria example, RowBounds rowBounds);

    List<Dsdp> selectByExample(DsdpCriteria example);

    Dsdp selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dsdp record, @Param("example") DsdpCriteria example);

    int updateByExample(@Param("record") Dsdp record, @Param("example") DsdpCriteria example);

    int updateByPrimaryKeySelective(Dsdp record);

    int updateByPrimaryKey(Dsdp record);

}