package com.cssnj.ywgl.domain.xtqx;

import com.cssnj.ywgl.vo.xtzy.ResourceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface RoleMenuMapper {
    long countByExample(RoleMenuCriteria example);

    int deleteByExample(RoleMenuCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    List<RoleMenu> selectByExampleWithRowbounds(RoleMenuCriteria example, RowBounds rowBounds);

    List<RoleMenu> selectByExample(RoleMenuCriteria example);

    RoleMenu selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuCriteria example);

    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuCriteria example);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

    List<ResourceVo> selectForLogin(String yhId);

    int insertBatch(List<RoleMenu> roleMenus);
}