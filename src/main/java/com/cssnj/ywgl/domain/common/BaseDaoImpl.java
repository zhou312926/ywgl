package com.cssnj.ywgl.domain.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created by yangxi on 2017/8/7.
 */
@Repository
public class BaseDaoImpl implements BaseDao {
    private static final Logger logger = LoggerFactory
            .getLogger(BaseDaoImpl.class);
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(String tableName, Map<String, Object> paramMap) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("insert into " + tableName + getBrackets(true));
        Map<String, Object> map;
        Object[] paramObj = new Object[paramMap.keySet().size()];
        int i = 0;
        for (String key : paramMap.keySet()) {
            i = i + 1;
            if (i < paramMap.keySet().size()) {
                sql.append(key.toUpperCase() + ",");
            } else {
                sql.append(key.toUpperCase() + ",lr_sj" + getBrackets(false));
            }
        }
        sql.append(" values (");
        i = 0;
        for (Object object : paramMap.values()) {
            paramObj[i] = object;
            i = i + 1;
            if (i < paramMap.values().size()) {
                sql.append("?,");
            } else {
                sql.append("?," + "sysdate" + getBrackets(false));
            }
        }
        logger.info("执行INSERT语句:" + sql.toString());
//        i = 1;
//        for (Object object : paramObj) {
//            logger.info("参数值" + i + ":" + object.toString());
//            i = i + 1;
//        }
        return jdbcTemplate.update(sql.toString(), paramObj);
    }

    @Override
    public int delete(String tableName, Map<String, Object> paramMap) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("delete from " + tableName + " where ");
        int i = 0;
        for (String key : paramMap.keySet()) {
            i = i + 1;
            if (i < paramMap.keySet().size()) {
                sql.append(key.toUpperCase() + " = ? and ");
            } else {
                sql.append(key.toUpperCase() + " = ?");
            }
        }
        return jdbcTemplate.update(sql.toString(), preparedStatement -> {
            logger.info("执行DELETE语句:" + sql.toString());
            int n = 1;
            for (Object value : paramMap.values()) {
                logger.info("参数值" + n + ":" + value.toString());
                preparedStatement.setObject(n, value);
                n = n + 1;
            }
        });
    }

    @Override
    public int update(String tableName, Map<String, Object> updateMap, Map<String, Object> paramMap) throws SQLException {
        StringBuffer sql = new StringBuffer();
        sql.append("update  " + tableName + " set ");
        int i = 0;
        for (String key : updateMap.keySet()) {
            i = i + 1;
            if (i < updateMap.keySet().size()) {
                sql.append(key.toUpperCase() + " = ?, ");
            } else {
                sql.append(key.toUpperCase() + " = ?, xg_sj = sysdate ");
            }
        }
        i = 0;
        sql.append("where  ");
        for (String key : paramMap.keySet()) {
            i = i + 1;
            if (i < paramMap.keySet().size()) {
                sql.append(key.toUpperCase() + " = ? and ");
            } else {
                sql.append(key.toUpperCase() + " = ?");
            }
        }
        return jdbcTemplate.update(sql.toString(), preparedStatement -> {
            logger.info("执行UPDATE语句:" + sql.toString());
            int n = 1;
            for (Object value : updateMap.values()) {
                logger.info("更新列值" + n + ":" + value.toString());
                preparedStatement.setObject(n, value);
                n = n + 1;
            }
            for (Object value : paramMap.values()) {
                logger.info("条件值" + n + ":" + value.toString());
                preparedStatement.setObject(n, value);
                n = n + 1;
            }
        });
    }


    private String getBrackets(boolean isLeft) {
        if (isLeft == true) {
            return " ( ";
        } else {
            return " ) ";
        }
    }


}
