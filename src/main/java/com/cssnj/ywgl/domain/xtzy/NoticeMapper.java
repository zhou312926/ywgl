package com.cssnj.ywgl.domain.xtzy;

import com.cssnj.ywgl.vo.xtzy.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    int countByExample(NoticeCriteria example);

    int deleteByExample(NoticeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExampleWithRowbounds(NoticeCriteria example, RowBounds rowBounds);

    List<Notice> selectByExample(NoticeCriteria example);

    Notice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeCriteria example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeCriteria example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<NoticeVo> selectByYhId(String yhId);

    List<NoticeVo> selectForList(Map map);

    NoticeVo selectByPk(String id);

}