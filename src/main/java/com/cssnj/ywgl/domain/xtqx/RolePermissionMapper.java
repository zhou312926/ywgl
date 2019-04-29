package com.cssnj.ywgl.domain.xtqx;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    long countByExample(RolePermissionCriteria example);

    int deleteByExample(RolePermissionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    List<RolePermission> selectByExampleWithRowbounds(RolePermissionCriteria example, RowBounds rowBounds);

    List<RolePermission> selectByExample(RolePermissionCriteria example);

    RolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionCriteria example);

    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionCriteria example);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    List<String> selectForlogin(String yhId);

    int insertBatch(List<RolePermission> rolePermissions);
}