package com.cssnj.ywgl.domain.xtqx;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    long countByExample(UserRoleCriteria example);

    int deleteByExample(UserRoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExampleWithRowbounds(UserRoleCriteria example, RowBounds rowBounds);

    List<UserRole> selectByExample(UserRoleCriteria example);

    UserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<String> selectForLogin(String yhId);

    int insertBatch(List<UserRole> roles);
}