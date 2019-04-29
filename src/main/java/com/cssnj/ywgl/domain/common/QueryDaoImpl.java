package com.cssnj.ywgl.domain.common;

import com.cssnj.ywgl.utils.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by yangxi on 2017/8/7.
 */
@Repository
public class QueryDaoImpl implements QueryDao {

    private static final Logger logger = LoggerFactory
            .getLogger(QueryDaoImpl.class);
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据信息编码查询名称
     *
     * @param xxBm
     * @return
     */
    @Override
    public String getXxnrByXxbm(String xxBm) throws SQLException {
        if (null == xxBm || "".equals(xxBm)) {
            return null;
        }
        return jdbcTemplate.queryForObject("select z.msg_mc from portal_dm_msg z where z.msg_dm=? and z.xy_bj='1' ", new Object[]{xxBm}, String.class);
    }

    @Override
    public String getRznrByRzbm(String rzBm) throws SQLException {
        if (null == rzBm || "".equals(rzBm)) {
            return null;
        }
        return jdbcTemplate.queryForObject("select z.rz_mb from portal_dm_rzlx z where z.rzlx_dm=? and z.xy_bj='1' ", new Object[]{rzBm}, String.class);
    }

    @Override
    public Date getSqlDate(String sqlType, String utilType) throws SQLException {
        String object = this.jdbcTemplate.queryForObject("select date_format(now(6),'" + sqlType + "') from dual", String.class);
        try {
            java.util.Date date = DateUtils.parseDate(object, Locale.CHINA, utilType);
            return DateUtil.parseUtilToSql(date);
        } catch (ParseException e) {
            throw new SQLException(e);
        }
    }


    @Override
    public String getDate(String dateType) throws SQLException {
        if (null == dateType || "".equals(dateType)) {
            dateType = "%Y-%m-%d";
        }
        return jdbcTemplate.queryForObject("select date_format(now(6),?) from dual", new Object[]{dateType},
                String.class);
    }

    @Override
    public Timestamp getSystimestamp() throws SQLException {
        return jdbcTemplate.queryForObject("select now(6) from dual",
                Timestamp.class);
    }


    @Override
    public SqlRowSet queryForRowSet(String sql, List param) {
        try {
            return this.jdbcTemplate.queryForRowSet(sql, param.toArray());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }


    @Override
    public List<Map<String, Object>> queryForList(String sql, List param) {
        try {
            return this.jdbcTemplate.queryForList(sql, param.toArray());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> queryForList(String sql, Object[] objects) {
        try {
            return this.jdbcTemplate.queryForList(sql, objects);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> queryForList(String sql, Object[] objects, Class requiredType) {
        try {
            return this.jdbcTemplate.queryForList(sql, objects, requiredType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public List query(String sql, List param, Class returnClass) {
        RowMapper<Class> rowMapper = BeanPropertyRowMapper.newInstance(returnClass);
        try {
            return this.jdbcTemplate.query(sql, param.toArray(), rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Map<String, Object> queryformap(String sql, List param) {
        try {
            return this.jdbcTemplate.queryForMap(sql, param.toArray());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Map<String, Object> queryformap(String sql, Object param) {
        try {
            return this.jdbcTemplate.queryForMap(sql, new Object[]{param});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Object queryForObject(String sql, List param, Class returnClass) {
        try {
            return this.jdbcTemplate.queryForObject(sql, param.toArray(), BeanPropertyRowMapper.newInstance(returnClass));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public <T> T queryForBean(String sql, List param, Class<T> clazz) {
        try {
            return this.jdbcTemplate.queryForObject(sql, param.toArray(), BeanPropertyRowMapper.newInstance(clazz));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public <T> List<T> queryForList(String sql, List param, Class<T> clazz) {
        try {
            return jdbcTemplate.queryForList(sql, param.toArray(), clazz);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> queryForList(String sql, Object param) {
        try {
            return this.queryForList(sql, new Object[]{param});
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


}
