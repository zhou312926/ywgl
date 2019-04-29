package com.cssnj.ywgl.domain.jnkp;

import com.cssnj.ywgl.vo.jnkp.DsxxVo;
import com.cssnj.ywgl.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface DsxxMapper {
    long countByExample(DsxxCriteria example);

    int deleteByExample(DsxxCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Dsxx record);

    int insertSelective(Dsxx record);

    List<Dsxx> selectByExampleWithRowbounds(DsxxCriteria example, RowBounds rowBounds);

    List<Dsxx> selectByExample(DsxxCriteria example);

    Dsxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dsxx record, @Param("example") DsxxCriteria example);

    int updateByExample(@Param("record") Dsxx record, @Param("example") DsxxCriteria example);

    int updateByPrimaryKeySelective(Dsxx record);

    int updateByPrimaryKey(Dsxx record);

    int countForList(@Param("xm") String xm, @Param("bmzbId") String bmzbId);

    List<DsxxVo> selectForList(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("offset") int offset, @Param("rows") int rows);

    DsxxVo selectByPk(String id);

}