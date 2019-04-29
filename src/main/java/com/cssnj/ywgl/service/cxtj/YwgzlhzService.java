package com.cssnj.ywgl.service.cxtj;

import com.cssnj.ywgl.domain.common.QueryDaoImpl;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class YwgzlhzService extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(YwwthzService.class);

    @Autowired
    private QueryDaoImpl queryDao;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadHzList".equals(jsonRequest.getHandle())) {
            return loadHzList(jsonRequest);
        }
        return null;
    }

    private JsonResponse loadHzList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String hzrqq = (String) jsonRequest.getData().get("hzrqq");
        String hzrqz = (String) jsonRequest.getData().get("hzrqz");
        String gzlq = (String) jsonRequest.getData().get("gzlq");
        String gzlz = (String) jsonRequest.getData().get("gzlz");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        String sql = "select id, xm, bmzbId, bmzbMc, (wtl + jbl) hjs, wtl, jbl\n" +
                "from (select t.id\n" +
                "           , t.xm\n" +
                "           , a.id                                                                             bmzbId\n" +
                "           , a.mc                                                                             bmzbMc\n" +
                "           , (SELECT count(1)\n" +
                "              FROM t_yw_wtxx x\n" +
                "              WHERE x.lrry = t.id\n" +
                "                AND x.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                "                AND x.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)) wtl\n" +
                "           , (SELECT count(1)\n" +
                "              FROM t_yw_ywjb x\n" +
                "              WHERE x.lrry = t.id\n" +
                "                AND x.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                "                AND x.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)) jbl\n" +
                "      from t_xt_yhxx t,\n" +
                "           t_xt_bmzb a\n" +
                "      where t.bmzb_id = a.id\n" +
                "        and t.lx = '1'\n" +
                "        AND t.yxbz = 'Y') xx\n" +
                "where 1=1";

        List params = new ArrayList();
        params.add(hzrqq);
        params.add(hzrqz);
        params.add(hzrqq);
        params.add(hzrqz);
        if (!StringUtils.isEmpty(gzlq)) {
            params.add(gzlq);
            sql += " and (wtl + jbl) >= ?\n";
        }
        if (!StringUtils.isEmpty(gzlz)) {
            params.add(gzlz);
            sql += " and (wtl + jbl) <= ?\n";
        }
        String sql2 = "SELECT count(1) cnt FROM (" + sql + ") yy";
        Map map = queryDao.queryformap(sql2, params);
        params.add(offset);
        params.add(rows);
        sql += " ORDER BY bmzbMc LIMIT ?,?";
        List<Map<String, Object>> list = queryDao.queryForList(sql, params);

        jsonResponse.getData().put("count", map.get("cnt"));
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }
}
