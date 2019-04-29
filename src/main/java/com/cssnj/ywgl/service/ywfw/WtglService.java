package com.cssnj.ywgl.service.ywfw;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.cssnj.ywgl.domain.common.QueryDaoImpl;
import com.cssnj.ywgl.domain.ywdm.*;
import com.cssnj.ywgl.domain.ywfw.WthfMapper;
import com.cssnj.ywgl.domain.ywfw.Wtxx;
import com.cssnj.ywgl.domain.ywfw.WtxxCriteria;
import com.cssnj.ywgl.domain.ywfw.WtxxMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.ywfw.WthfVo;
import com.cssnj.ywgl.vo.ywfw.WtxxVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/2/14 09:14
 */
@Service
public class WtglService extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(WtglService.class);

    @Autowired
    private QueryDaoImpl queryDao;
    @Autowired
    private WtxxMapper wtxxMapper;
    @Autowired
    private WthfMapper wthfMapper;
    @Autowired
    private WtlxMapper wtlxMapper;
    @Autowired
    private YyxtMapper yyxtMapper;
    @Autowired
    private YwmkMapper ywmkMapper;
    @Autowired
    private WtztMapper wtztMapper;


    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("countYyxt".equals(jsonRequest.getHandle())) {
            return countYyxt(jsonRequest);
        } else if ("countWtlx".equals(jsonRequest.getHandle())) {
            return countWtlx(jsonRequest);
        } else if ("countXzwt".equals(jsonRequest.getHandle())) {
            return countXzwt(jsonRequest);
        } else if ("countWjjwt".equals(jsonRequest.getHandle())) {
            return countWjjwt(jsonRequest);
        } else if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getWtxx".equals(jsonRequest.getHandle())) {
            return getWtxx(jsonRequest);
        } else if ("saveWtxx".equals(jsonRequest.getHandle())) {
            return saveWtxx(jsonRequest);
        } else if ("delWtxx".equals(jsonRequest.getHandle())) {
            return delWtxx(jsonRequest);
        } else if ("uploadWtxx".equals(jsonRequest.getHandle())) {
            return uploadWtxx(jsonRequest);
        }
        return null;
    }

    private JsonResponse countYyxt(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String sql = "SELECT a.mc yyxt, ifnull(b.cnt, 0) cnt FROM t_dm_yw_yyxt a LEFT JOIN (SELECT yyxt_dm, count(yyxt_dm) cnt FROM t_yw_wtxx GROUP BY yyxt_dm) b ON a.dm = b.yyxt_dm";
        List<Map<String, Object>> ywxtList = queryDao.queryForList(sql, new ArrayList());
        List<Object> legend = new ArrayList<>();
        List<Map<String, Object>> series = new ArrayList<>();
        Map<String, Object> d;
        for (Map<String, Object> map : ywxtList) {
            legend.add(map.get("yyxt"));
            d = new HashMap<>();
            d.put("name", map.get("yyxt"));
            d.put("value", map.get("cnt"));
            series.add(d);
        }
        Map map = new HashMap();
        map.put("legend", legend);
        map.put("series", series);
        jsonResponse.setData(map);
        return jsonResponse;
    }

    private JsonResponse countWtlx(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String sql = "SELECT a.mc wtlx, ifnull(b.cnt, 0) cnt FROM t_dm_yw_wtlx a LEFT JOIN (SELECT wtlx_dm, count(wtlx_dm) cnt FROM t_yw_wtxx GROUP BY wtlx_dm) b ON a.dm = b.wtlx_dm";
        List<Map<String, Object>> wtlxList = queryDao.queryForList(sql, new ArrayList());
        List<Object> legend = new ArrayList<>();
        List<Map<String, Object>> series = new ArrayList<>();
        Map<String, Object> d;
        for (Map<String, Object> map : wtlxList) {
            legend.add(map.get("wtlx"));
            d = new HashMap<>();
            d.put("name", map.get("wtlx"));
            d.put("value", map.get("cnt"));
            series.add(d);
        }
        Map map = new HashMap();
        map.put("legend", legend);
        map.put("series", series);
        jsonResponse.setData(map);
        return jsonResponse;
    }

    private JsonResponse countXzwt(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String sql = "SELECT date_format(a.d, '%m-%d') d, ifnull(b.cnt, 0) cnt FROM (SELECT curdate() d UNION ALL SELECT date_sub(curdate(), INTERVAL 1 DAY) d UNION ALL SELECT date_sub(curdate(), INTERVAL 2 DAY) d UNION ALL SELECT date_sub(curdate(), INTERVAL 3 DAY) d UNION ALL SELECT date_sub(curdate(), INTERVAL 4 DAY) d UNION ALL SELECT date_sub(curdate(), INTERVAL 5 DAY) d UNION ALL SELECT date_sub(curdate(), INTERVAL 6 DAY) d) a LEFT JOIN (SELECT date_format(t.lrsj, '%y-%m-%d') d, count(1) cnt FROM t_yw_wtxx t WHERE t.lrsj >= date_sub(curdate(), INTERVAL 6 DAY) GROUP BY date_format(t.lrsj, '%y-%m-%d')) b ON a.d = b.d ORDER BY a.d";
        List<Map<String, Object>> list = queryDao.queryForList(sql, new ArrayList());
        List<Object> xAxis = new ArrayList<>();
        List<Object> series = new ArrayList<>();
        for (Map<String, Object> map : list) {
            xAxis.add(map.get("d"));
            series.add(map.get("cnt"));
        }
        Map map = new HashMap();
        map.put("xAxis", xAxis);
        map.put("series", series);
        jsonResponse.setData(map);
        return jsonResponse;
    }

    private JsonResponse countWjjwt(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String sql = "SELECT csz FROM t_cs_xtcs t WHERE t.csbm = 'wjjwttj' AND t.yxbz = 'Y'";
        Map cs = queryDao.queryformap(sql, new ArrayList());

        List params = new ArrayList();
        params.add(cs.get("csz"));
        sql = "SELECT b.xm, count(1) cnt FROM t_yw_wtxx a, t_xt_yhxx b WHERE a.lrry = b.id AND b.yxbz='Y' AND a.lrsj <= date_sub(curdate(), INTERVAL ? DAY) AND a.wtzt_dm <> '04' GROUP BY b.xm ORDER BY count(1)";
        List<Map<String, Object>> list = queryDao.queryForList(sql, params);
        List<Object> xAxis = new ArrayList<>();
        List<Object> series = new ArrayList<>();
        for (Map<String, Object> map : list) {
            xAxis.add(map.get("xm"));
            series.add(map.get("cnt"));
        }
        if (xAxis.size() == 0) {
            xAxis.add("暂无超期未解决问题");
            series.add("0");
        }
        Map map = new HashMap();
        map.put("cqts", cs.get("csz"));
        map.put("xAxis", xAxis);
        map.put("series", series);
        jsonResponse.setData(map);
        return jsonResponse;
    }


    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String bt = (String) jsonRequest.getData().get("bt");
        String wtlxDm = (String) jsonRequest.getData().get("wtlxDm");
        String ywmkDm = (String) jsonRequest.getData().get("ywmkDm");
        String yyxtDm = (String) jsonRequest.getData().get("yyxtDm");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        wtlxDm = "0".equals(wtlxDm) ? "" : wtlxDm;
        yyxtDm = "0".equals(yyxtDm) ? "" : yyxtDm;
        ywmkDm = "0".equals(ywmkDm) ? "" : ywmkDm;

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

//        WtxxCriteria wtxxCriteria = new WtxxCriteria();
//        WtxxCriteria.Criteria criteria = wtxxCriteria.createCriteria();
//        if (!StringUtils.isEmpty(bt)) {
//            criteria.andBtLike(bt);
//        }
//        if (!StringUtils.isEmpty(wtlxDm)) {
//            criteria.andWtlxDmEqualTo(wtlxDm);
//        }
//        if (!StringUtils.isEmpty(yyxtDm)) {
//            criteria.andYyxtDmEqualTo(yyxtDm);
//        }
//        if (!StringUtils.isEmpty(ywmkDm)) {
//            criteria.andYwmkDmEqualTo(ywmkDm);
//        }
//        int count = wtxxMapper.countByExample(wtxxCriteria);
        int count=wtxxMapper.countForWtglList(loginInfo.getYhId(), loginInfo.getBmzbId(), bt, wtlxDm, yyxtDm, ywmkDm);
        List<WtxxVo> list = wtxxMapper.selectForWtglList(loginInfo.getYhId(), loginInfo.getBmzbId(), bt, wtlxDm, yyxtDm, ywmkDm, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }


    private JsonResponse getWtxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        WtxxVo wtxxVo = new WtxxVo();
        List<WthfVo> wthfList = new ArrayList<>();
        if (!StringUtils.isEmpty(id)) {
            wtxxVo = wtxxMapper.selectByPk(id);
            wthfList = wthfMapper.selectForWtclList(id);
        }
        jsonResponse.getData().put("wtxx", wtxxVo);
        jsonResponse.getData().put("wthfList", wthfList);
        return jsonResponse;
    }

    private JsonResponse saveWtxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String id = (String) jsonRequest.getData().get("id");
        String bt = (String) jsonRequest.getData().get("bt");
        String wtlxDm = (String) jsonRequest.getData().get("wtlx");
        String yyxtDm = (String) jsonRequest.getData().get("yyxt");
        String ywmkDm = (String) jsonRequest.getData().get("ywmk");
        String wtztDm = (String) jsonRequest.getData().get("wtzt");
        String wtms = (String) jsonRequest.getData().get("wtms");
        String clfa = (String) jsonRequest.getData().get("clfa");

        if (StringUtils.isEmpty(bt) || StringUtils.isEmpty(wtlxDm) || StringUtils.isEmpty(yyxtDm) || StringUtils.isEmpty(wtms) || StringUtils.isEmpty(wtztDm)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        } else if (bt.trim().length() < 20) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("标题至少20个字描述");
            return jsonResponse;
        } else if (bt.trim().length() > 200) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("标题不能超过200个字描述");
            return jsonResponse;
        } else if (wtms.trim().length() < 20) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("详细描述至少20个字描述");
            return jsonResponse;
        } else if (wtms.trim().length() > 4000) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("详细描述不能超过4000个字描述");
            return jsonResponse;
        } else if ("04".equals(wtztDm)) {
            if (StringUtils.isEmpty(clfa)) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("已解决问题处理方案不能为空");
                return jsonResponse;
            } else if (clfa.trim().length() < 20) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("处理方案至少20个字描述");
                return jsonResponse;
            } else if (clfa.trim().length() > 4000) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("处理方案不能超过4000个字描述");
                return jsonResponse;
            }
        }

        Wtxx wtxx = new Wtxx();
        wtxx.setBt(bt);
        wtxx.setWtlxDm(wtlxDm);
        wtxx.setYyxtDm(yyxtDm);
        wtxx.setYwmkDm("0".equals(ywmkDm) ? "" : ywmkDm);
        wtxx.setWtztDm(wtztDm);
        wtxx.setMs(wtms);
        wtxx.setClfa(clfa);
        wtxx.setBmzbId(loginInfo.getBmzbId());

        if (StringUtils.isEmpty(id)) {
            wtxx.setId(ApplicationUtil.createDBID());
            wtxx.setLrry(loginInfo.getYhId());
            wtxx.setLrsj(DateUtil.getNowSqlDate());
            wtxxMapper.insert(wtxx);
        } else {
            wtxx.setId(id);
            wtxx.setXgry(loginInfo.getYhId());
            wtxx.setXgsj(DateUtil.getNowTimestamp());
            wtxxMapper.updateByPrimaryKeySelective(wtxx);
        }
        return jsonResponse;
    }


    private JsonResponse delWtxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
//        String id = (String) jsonRequest.getData().get("id");
//        if (!StringUtils.isEmpty(id)) {
//            wtxxMapper.deleteByPrimaryKey(id);
//        }
        return jsonResponse;
    }

    private JsonResponse uploadWtxx(JsonRequest<MultipartFile> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        InputStream is = null;
        List<Object> data = null;
        try {
//        InputStream inputStream = FileUtil.getResourcesFileInputStream("2007.xlsx");
            is = jsonRequest.getData().getInputStream();
            data = EasyExcelFactory.read(is, new Sheet(1, 0));
        } catch (IOException e) {
            logger.error("读取问题信息模板出错", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        if (data == null || data.size() <= 1) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("空数据模板");
            return jsonResponse;
        }
        if (data.size() > 1000) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("数据超过1000条，请分批上传");
            return jsonResponse;
        }

        List<Wtxx> wtxxes = new ArrayList<>();
        Wtxx wtxx;
        for (int i = 1; i < data.size(); i++) {
            ArrayList rows = (ArrayList) data.get(i);
            if (rows.size() < 5) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行数据不完整");
                return jsonResponse;
            } else if (rows.get(0) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"标题\"不能为空");
                return jsonResponse;
            } else if (String.valueOf(rows.get(0)).trim().length() < 20) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"标题\"至少20个字描述");
                return jsonResponse;
            } else if (String.valueOf(rows.get(0)).trim().length() > 200) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"标题\"不能超过200个字描述");
                return jsonResponse;
            } else if (rows.get(1) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"问题类型\"不能为空");
                return jsonResponse;
            } else if (rows.get(2) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"应用系统\"不能为空");
                return jsonResponse;
            } else if (rows.get(4) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"详细描述\"不能为空");
                return jsonResponse;
            } else if (String.valueOf(rows.get(4)).trim().length() < 20) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"详细描述\"至少20个字描述");
                return jsonResponse;
            } else if (String.valueOf(rows.get(4)).trim().length() > 4000) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"详细描述\"不能超过4000个字描述");
                return jsonResponse;
            } else if (rows.get(5) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"问题状态\"不能为空");
                return jsonResponse;
            } else if (!"已解决".equals(rows.get(5)) && (rows.size() > 6 && rows.get(6) != null)) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行未解决问题\"处理方案\"无需录入");
                return jsonResponse;
            } else if ("已解决".equals(rows.get(5))) {
                if (rows.size() < 7 || rows.get(6) == null) {
                    jsonResponse.setCode("-1");
                    jsonResponse.setMsg("第【" + (i + 1) + "】行已解决问题\"处理方案\"不能为空");
                    return jsonResponse;
                } else if (String.valueOf(rows.get(6)).trim().length() < 20) {
                    jsonResponse.setCode("-1");
                    jsonResponse.setMsg("第【" + (i + 1) + "】行已解决问题\"处理方案\"至少20个字描述");
                    return jsonResponse;
                } else if (String.valueOf(rows.get(6)).trim().length() > 4000) {
                    jsonResponse.setCode("-1");
                    jsonResponse.setMsg("第【" + (i + 1) + "】行已解决问题\"处理方案\"不能超过4000个字描述");
                    return jsonResponse;
                }
            }

            WtlxCriteria wtlxCriteria = new WtlxCriteria();
            WtlxCriteria.Criteria criteria1 = wtlxCriteria.createCriteria();
            criteria1.andMcEqualTo((String) rows.get(1));
            List<Wtlx> wtlxes = wtlxMapper.selectByExample(wtlxCriteria);
            if (wtlxes.size() == 0) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"问题类型\"系统不存在");
                return jsonResponse;
            }
            YyxtCriteria yyxtCriteria = new YyxtCriteria();
            YyxtCriteria.Criteria criteria2 = yyxtCriteria.createCriteria();
            criteria2.andMcEqualTo((String) rows.get(2));
            List<Yyxt> yyxts = yyxtMapper.selectByExample(yyxtCriteria);
            if (yyxts.size() == 0) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"应用系统\"系统不存在");
                return jsonResponse;
            }
            List<Ywmk> ywmks = new ArrayList<>();
            if (rows.get(3) != null && !"不限".equals(rows.get(3))) {
                YwmkCriteria ywmkCriteria = new YwmkCriteria();
                YwmkCriteria.Criteria criteria3 = ywmkCriteria.createCriteria();
                criteria3.andMcEqualTo((String) rows.get(3));
                ywmks = ywmkMapper.selectByExample(ywmkCriteria);
                if (ywmks.size() == 0) {
                    jsonResponse.setCode("-1");
                    jsonResponse.setMsg("第【" + (i + 1) + "】行\"业务模块\"系统不存在");
                    return jsonResponse;
                }
            }
            WtztCriteria wtztCriteria = new WtztCriteria();
            WtztCriteria.Criteria criteria4 = wtztCriteria.createCriteria();
            criteria4.andMcEqualTo((String) rows.get(5));
            List<Wtzt> wtzts = wtztMapper.selectByExample(wtztCriteria);
            if (wtzts.size() == 0) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"问题状态\"系统不存在");
                return jsonResponse;
            }

            wtxx = new Wtxx();
            wtxx.setBt((String) rows.get(0));
            wtxx.setWtlxDm(wtlxes.get(0).getDm());
            wtxx.setYyxtDm(yyxts.get(0).getDm());
            wtxx.setYwmkDm(ywmks.size() == 0 ? "" : ywmks.get(0).getDm());
            wtxx.setWtztDm(wtzts.get(0).getDm());
            wtxx.setMs((String) rows.get(4));
            wtxx.setClfa(rows.size() < 7 || rows.get(6) == null ? "" : (String) rows.get(6));
            wtxx.setBmzbId(loginInfo.getBmzbId());
            wtxx.setId(ApplicationUtil.createDBID());
            wtxx.setLrry(loginInfo.getYhId());
            wtxx.setLrsj(DateUtil.getNowSqlDate());
            wtxxes.add(wtxx);
        }

        wtxxMapper.insertBatch(wtxxes);
        jsonResponse.setMsg("上传成功");
        return jsonResponse;
    }
}
