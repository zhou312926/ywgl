package com.cssnj.ywgl.domain.ywfw;

import com.cssnj.ywgl.vo.ywfw.WthfVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface WthfMapper {
    long countByExample(WthfCriteria example);

    int deleteByExample(WthfCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Wthf record);

    int insertSelective(Wthf record);

    List<Wthf> selectByExampleWithRowbounds(WthfCriteria example, RowBounds rowBounds);

    List<Wthf> selectByExample(WthfCriteria example);

    Wthf selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Wthf record, @Param("example") WthfCriteria example);

    int updateByExample(@Param("record") Wthf record, @Param("example") WthfCriteria example);

    int updateByPrimaryKeySelective(Wthf record);

    int updateByPrimaryKey(Wthf record);

    List<WthfVo> selectForWtclList(String wtxxId);

}