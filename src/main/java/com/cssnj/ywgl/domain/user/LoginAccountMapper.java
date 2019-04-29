package com.cssnj.ywgl.domain.user;

import com.cssnj.ywgl.dto.user.LoginInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface LoginAccountMapper {
    long countByExample(LoginAccountCriteria example);

    int deleteByExample(LoginAccountCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(LoginAccount record);

    int insertSelective(LoginAccount record);

    List<LoginAccount> selectByExampleWithRowbounds(LoginAccountCriteria example, RowBounds rowBounds);

    List<LoginAccount> selectByExample(LoginAccountCriteria example);

    LoginAccount selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LoginAccount record, @Param("example") LoginAccountCriteria example);

    int updateByExample(@Param("record") LoginAccount record, @Param("example") LoginAccountCriteria example);

    int updateByPrimaryKeySelective(LoginAccount record);

    int updateByPrimaryKey(LoginAccount record);

    LoginInfo selectForLogin(String dlzh);
}