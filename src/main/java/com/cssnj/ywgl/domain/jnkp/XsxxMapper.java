package com.cssnj.ywgl.domain.jnkp;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface XsxxMapper {
    long countByExample(XsxxCriteria example);

    int deleteByExample(XsxxCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Xsxx record);

    int insertSelective(Xsxx record);

    List<Xsxx> selectByExampleWithRowbounds(XsxxCriteria example, RowBounds rowBounds);

    List<Xsxx> selectByExample(XsxxCriteria example);

    Xsxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Xsxx record, @Param("example") XsxxCriteria example);

    int updateByExample(@Param("record") Xsxx record, @Param("example") XsxxCriteria example);

    int updateByPrimaryKeySelective(Xsxx record);

    int updateByPrimaryKey(Xsxx record);

    int insertBatch(List<Xsxx> xsxxes);

    int updateByDsxsSelective(Xsxx record);
}