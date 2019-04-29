package com.cssnj.ywgl.domain.common;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by yangxi on 2017/8/7.
 */
public interface QueryDao {


    /**
     * 根据信息编码查询名称
     *
     * @param xxbm
     * @return
     */
    String getXxnrByXxbm(String xxbm) throws SQLException;

    String getRznrByRzbm(String xxbm) throws SQLException;


    Date getSqlDate(String sqlType, String utilType) throws SQLException;


    String getDate(String dateType) throws SQLException;

    Timestamp getSystimestamp() throws SQLException;


    SqlRowSet queryForRowSet(String sql, List param);


    List<Map<String, Object>> queryForList(String sql, List param);

    List<Map<String, Object>> queryForList(String sql, Object[] param);

    List<Map<String, Object>> queryForList(String sql, Object[] param, Class requiredType);


    List<Map<String, Object>> queryForList(String sql, Object param);

    List query(String sql, List param, Class returnClass);

    Map<String, Object> queryformap(String sql, List param);

    Map<String, Object> queryformap(String sql, Object param);

    Object queryForObject(String sql, List param, Class returnClass);

    <T> List<T> queryForList(String sql, List param, Class<T> clazz);

    <T> T queryForBean(String sql, List param, Class<T> clazz);
}
