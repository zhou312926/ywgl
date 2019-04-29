package com.cssnj.ywgl.service.cxtj;

import com.cssnj.ywgl.domain.common.QueryDaoImpl;
import com.cssnj.ywgl.domain.ywfw.WtxxCriteria;
import com.cssnj.ywgl.domain.ywfw.WtxxMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.ywfw.WtxxVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/4/10 16:30
 */
@Service
public class YwwthzService extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(YwwthzService.class);

    @Autowired
    private QueryDaoImpl queryDao;
    @Autowired
    private WtxxMapper wtxxMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadHzList".equals(jsonRequest.getHandle())) {
            return loadHzList(jsonRequest);
        } else if ("loadMxList".equals(jsonRequest.getHandle())) {
            return loadMxList(jsonRequest);
        }
        return null;
    }


    private JsonResponse loadHzList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String hzlx = (String) jsonRequest.getData().get("hzlx");
        String hzrqq = (String) jsonRequest.getData().get("hzrqq");
        String hzrqz = (String) jsonRequest.getData().get("hzrqz");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");
        String sql1;

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        if ("0".equals(hzlx)) {//按人员
            sql1 = "SELECT\n" +
                    "  t.lrry                        hzid,\n" +
                    "  a.xm                          hzmc,\n" +
                    "  count(1)                      wthjs,\n" +
                    "  (SELECT count(1)\n" +
                    "   FROM t_yw_wtxx x\n" +
                    "   WHERE x.lrry = t.lrry\n" +
                    "         AND x.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                    "         AND x.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)\n" +
                    "         AND x.wtzt_dm = '04')  wtyjjs,\n" +
                    "  (SELECT count(1)\n" +
                    "   FROM t_yw_wtxx x\n" +
                    "   WHERE x.lrry = t.lrry AND x.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                    "         AND x.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)\n" +
                    "         AND x.wtzt_dm <> '04') wtwjjs\n" +
                    "FROM t_yw_wtxx t, t_xt_yhxx a\n" +
                    "WHERE t.lrry = a.id\n" +
                    "      AND a.yxbz >= 'Y'\n" +
                    "      AND t.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                    "      AND t.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)\n" +
                    "GROUP BY t.lrry, a.xm";
        } else {//默认按部门
            sql1 = "SELECT\n" +
                    "  t.bmzb_id                     hzid,\n" +
                    "  a.mc                          hzmc,\n" +
                    "  count(1)                      wthjs,\n" +
                    "  (SELECT count(1)\n" +
                    "   FROM t_yw_wtxx x\n" +
                    "   WHERE x.bmzb_id = t.bmzb_id\n" +
                    "         AND x.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                    "         AND x.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)\n" +
                    "         AND x.wtzt_dm = '04')  wtyjjs,\n" +
                    "  (SELECT count(1)\n" +
                    "   FROM t_yw_wtxx x\n" +
                    "   WHERE x.bmzb_id = t.bmzb_id\n" +
                    "         AND x.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                    "         AND x.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)\n" +
                    "         AND x.wtzt_dm <> '04') wtwjjs\n" +
                    "FROM t_yw_wtxx t, t_xt_bmzb a\n" +
                    "WHERE t.bmzb_id = a.id\n" +
                    "      AND a.yxbz >= 'Y'\n" +
                    "      AND t.lrsj >= str_to_date(?, '%Y-%m-%d')\n" +
                    "      AND t.lrsj < date_add(str_to_date(?, '%Y-%m-%d'), INTERVAL 1 DAY)\n" +
                    "GROUP BY t.bmzb_id, a.mc";
        }

        List params = new ArrayList();
        params.add(hzrqq);
        params.add(hzrqz);
        params.add(hzrqq);
        params.add(hzrqz);
        params.add(hzrqq);
        params.add(hzrqz);
        String sql2 = "SELECT count(1) cnt FROM (" + sql1 + ") xx";
        Map map = queryDao.queryformap(sql2, params);

        params.add(offset);
        params.add(rows);
        sql1 += " LIMIT ?,?";
        List<Map<String, Object>> list = queryDao.queryForList(sql1, params);

        jsonResponse.getData().put("count", map.get("cnt"));
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse loadMxList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String hzlx = (String) jsonRequest.getData().get("hzlx");
        String hzid = (String) jsonRequest.getData().get("hzid");
        String hzrqq = (String) jsonRequest.getData().get("hzrqq");
        String hzrqz = (String) jsonRequest.getData().get("hzrqz");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        WtxxCriteria wtxxCriteria = new WtxxCriteria();
        WtxxCriteria.Criteria criteria = wtxxCriteria.createCriteria();
        if ("0".equals(hzlx)) {
            criteria.andLrryEqualTo(hzid);
        } else {
            criteria.andBmzbIdEqualTo(hzid);
        }
        criteria.andLrsjGreaterThanOrEqualTo(DateUtil.parseStringToUtil(hzrqq, "yyyy-MM-dd"));
        criteria.andLrsjLessThan(DateUtil.dayAddNum(DateUtil.parseStringToUtil(hzrqq, "yyyy-MM-dd"), 1));

        int count = wtxxMapper.countByExample(wtxxCriteria);

        Map params = new HashMap();
        params.put("hzrqq", hzrqq);
        params.put("hzrqz", hzrqz);
        if ("0".equals(hzlx)) {
            params.put("lrry", hzid);
        } else {
            params.put("bmzbId", hzid);
        }
        params.put("offset", offset);
        params.put("rows", rows);
        List<WtxxVo> list = wtxxMapper.selectForWtHzmxList(params);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", list);

        return jsonResponse;
    }
}
