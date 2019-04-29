package com.cssnj.ywgl.domain.dept;

import com.cssnj.ywgl.vo.dept.DeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface DeptMapper {
    int countByExample(DeptCriteria example);

    int deleteByExample(DeptCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExampleWithRowbounds(DeptCriteria example, RowBounds rowBounds);

    List<Dept> selectByExample(DeptCriteria example);

    Dept selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptCriteria example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptCriteria example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<DeptVo> selectByPage(@Param("yhId") String yhId, @Param("mc") String mc, @Param("sjbmzbId") String sjbmzbId, @Param("offset") int offset, @Param("rows") int rows);

    List<DeptVo> selectForList();

    List<DeptVo> selectForEdit();

    List<DeptVo> selectForYhxx();

    List<DeptVo> selectForDsxx();

}