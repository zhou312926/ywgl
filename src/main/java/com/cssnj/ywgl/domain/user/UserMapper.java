package com.cssnj.ywgl.domain.user;

import com.cssnj.ywgl.vo.user.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface UserMapper {
    int countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithRowbounds(UserCriteria example, RowBounds rowBounds);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserVo> selectForList(@Param("yhId") String yhId, @Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("offset") int offset, @Param("rows") int rows);

    int countForJsysq(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("jsId") String jsId);

    List<UserVo> selectForJsysq(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("jsId") String jsId, @Param("offset") int offset, @Param("rows") int rows);

    int countForJswsq(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("jsId") String jsId);

    List<UserVo> selectForJswsq(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("jsId") String jsId, @Param("offset") int offset, @Param("rows") int rows);

    int countForBmzbgl(@Param("xm") String xm, @Param("bmzbId") String bmzbId);

    List<UserVo> selectForBmzbgl(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("offset") int offset, @Param("rows") int rows);

    int countForDsgl(@Param("xm") String xm, @Param("bmzbId") String bmzbId);

    List<UserVo> selectForDsgl(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("offset") int offset, @Param("rows") int rows);

    int countForXsyfp(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("dsId") String dsId);

    List<UserVo> selectForXsyfp(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("dsId") String dsId, @Param("offset") int offset, @Param("rows") int rows);

    int countForXswfp(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("dsId") String dsId, @Param("dsYhId") String dsYhId);

    List<UserVo> selectForXswfp(@Param("xm") String xm, @Param("bmzbId") String bmzbId, @Param("dsId") String dsId, @Param("dsYhId") String dsYhId, @Param("offset") int offset, @Param("rows") int rows);


}