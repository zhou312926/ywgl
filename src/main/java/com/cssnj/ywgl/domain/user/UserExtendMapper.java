package com.cssnj.ywgl.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserExtendMapper {
    long countByExample(UserExtendCriteria example);

    int deleteByExample(UserExtendCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserExtend record);

    int insertSelective(UserExtend record);

    List<UserExtend> selectByExampleWithRowbounds(UserExtendCriteria example, RowBounds rowBounds);

    List<UserExtend> selectByExample(UserExtendCriteria example);

    UserExtend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserExtend record, @Param("example") UserExtendCriteria example);

    int updateByExample(@Param("record") UserExtend record, @Param("example") UserExtendCriteria example);

    int updateByPrimaryKeySelective(UserExtend record);

    int updateByPrimaryKey(UserExtend record);
}