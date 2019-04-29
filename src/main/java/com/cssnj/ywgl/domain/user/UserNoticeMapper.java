package com.cssnj.ywgl.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserNoticeMapper {
    long countByExample(UserNoticeCriteria example);

    int deleteByExample(UserNoticeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(UserNotice record);

    int insertSelective(UserNotice record);

    List<UserNotice> selectByExampleWithRowbounds(UserNoticeCriteria example, RowBounds rowBounds);

    List<UserNotice> selectByExample(UserNoticeCriteria example);

    UserNotice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserNotice record, @Param("example") UserNoticeCriteria example);

    int updateByExample(@Param("record") UserNotice record, @Param("example") UserNoticeCriteria example);

    int updateByPrimaryKeySelective(UserNotice record);

    int updateByPrimaryKey(UserNotice record);
}