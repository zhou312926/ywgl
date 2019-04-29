package com.cssnj.ywgl.domain.ywfw;

import com.cssnj.ywgl.vo.ywfw.YwjbVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface YwjbMapper {
    int countByExample(YwjbCriteria example);

    int deleteByExample(YwjbCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Ywjb record);

    int insertSelective(Ywjb record);

    List<Ywjb> selectByExampleWithRowbounds(YwjbCriteria example, RowBounds rowBounds);

    List<Ywjb> selectByExample(YwjbCriteria example);

    Ywjb selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Ywjb record, @Param("example") YwjbCriteria example);

    int updateByExample(@Param("record") Ywjb record, @Param("example") YwjbCriteria example);

    int updateByPrimaryKeySelective(Ywjb record);

    int updateByPrimaryKey(Ywjb record);

    List<YwjbVo> selectList(Map map);

    YwjbVo selectByPk(String id);

    int insertBatch(List<Ywjb> ywjbs);
}