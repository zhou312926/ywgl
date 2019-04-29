package com.cssnj.ywgl.domain.xtzy;

import com.cssnj.ywgl.vo.xtzy.ResourceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface ResourceMapper {
    long countByExample(ResourceCriteria example);

    int deleteByExample(ResourceCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExampleWithRowbounds(ResourceCriteria example, RowBounds rowBounds);

    List<Resource> selectByExample(ResourceCriteria example);

    Resource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceCriteria example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceCriteria example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    List<ResourceVo> selectForList(String yhId);

    List<ResourceVo> selectForEdit();

    List<ResourceVo> selectForJsfp(String jsId);
}