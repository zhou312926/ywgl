package com.cssnj.ywgl.domain.xtzy;

import com.cssnj.ywgl.vo.xtzy.ResourceVo;
import com.cssnj.ywgl.vo.xtzy.RoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface RoleMapper {
    long countByExample(RoleCriteria example);

    int deleteByExample(RoleCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExampleWithRowbounds(RoleCriteria example, RowBounds rowBounds);

    List<Role> selectByExample(RoleCriteria example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<RoleVo> selectForList(String loginYhId);

    List<RoleVo> selectForYhsq(@Param("loginYhId")String loginYhId,@Param("yhId") String yhId);

}