package com.cssnj.ywgl.domain.ywdm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface WtlxMapper {
    int countByExample(WtlxCriteria example);

    int deleteByPrimaryKey(String dm);

    int insert(Wtlx record);

    int insertSelective(Wtlx record);

    List<Wtlx> selectByExampleWithRowbounds(WtlxCriteria example, RowBounds rowBounds);

    List<Wtlx> selectByExample(WtlxCriteria example);

    Wtlx selectByPrimaryKey(String dm);

    int updateByPrimaryKeySelective(Wtlx record);

    int updateByPrimaryKey(Wtlx record);

    List<Wtlx> selectAll();
}