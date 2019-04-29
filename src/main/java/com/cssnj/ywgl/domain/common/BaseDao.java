package com.cssnj.ywgl.domain.common;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by yangxi on 2017/8/7.
 */
public interface BaseDao {

    int insert(String tableName, Map<String, Object> paramMap) throws SQLException;

    int delete(String tableName, Map<String, Object> paramMap) throws SQLException;

    int update(String tableName, Map<String, Object> updateMap, Map<String, Object> paramMap) throws SQLException;

  
}
