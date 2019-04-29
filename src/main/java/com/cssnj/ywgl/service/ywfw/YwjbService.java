package com.cssnj.ywgl.service.ywfw;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.cssnj.ywgl.domain.ywdm.Yyxt;
import com.cssnj.ywgl.domain.ywdm.YyxtCriteria;
import com.cssnj.ywgl.domain.ywdm.YyxtMapper;
import com.cssnj.ywgl.domain.ywfw.Ywjb;
import com.cssnj.ywgl.domain.ywfw.YwjbCriteria;
import com.cssnj.ywgl.domain.ywfw.YwjbMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.ywfw.YwjbVo;
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
 * @Date: 2019-04-11 10:30
 */
@Service
public class YwjbService extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(YwjbService.class);

    @Autowired
    private YwjbMapper ywjbMapper;
    @Autowired
    private YyxtMapper yyxtMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getYwjb".equals(jsonRequest.getHandle())) {
            return getYwjb(jsonRequest);
        } else if ("saveYwjb".equals(jsonRequest.getHandle())) {
            return saveYwjb(jsonRequest);
        } else if ("delYwjb".equals(jsonRequest.getHandle())) {
            return delYwjb(jsonRequest);
        } else if ("uploadYwjb".equals(jsonRequest.getHandle())) {
            return uploadYwjb(jsonRequest);
        }
        return null;
    }


    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String bt = (String) jsonRequest.getData().get("bt");
        String yyxtDm = (String) jsonRequest.getData().get("yyxtDm");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        yyxtDm = "0".equals(yyxtDm) ? "" : yyxtDm;

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        YwjbCriteria ywjbCriteria = new YwjbCriteria();
        YwjbCriteria.Criteria criteria = ywjbCriteria.createCriteria();
        if (!StringUtils.isEmpty(bt)) {
            criteria.andBtLike(bt);
        }
        if (!StringUtils.isEmpty(yyxtDm)) {
            criteria.andYyxtDmEqualTo(yyxtDm);
        }
        int count = ywjbMapper.countByExample(ywjbCriteria);

        Map params = new HashMap();
        params.put("loginYhId", loginInfo.getYhId());
        params.put("loginBmzbId", loginInfo.getBmzbId());
        params.put("bt", bt);
        params.put("yyxtDm", yyxtDm);
        params.put("offset", offset);
        params.put("rows", rows);
        List<YwjbVo> list = ywjbMapper.selectList(params);
        jsonResponse.getData().put("count", 20);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }


    private JsonResponse getYwjb(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        YwjbVo ywjbVo = ywjbMapper.selectByPk(id);
        if (ywjbVo == null) {
            ywjbVo = new YwjbVo();
        }
        jsonResponse.getData().put("ywjb", ywjbVo);
        return jsonResponse;
    }

    private JsonResponse saveYwjb(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String id = (String) jsonRequest.getData().get("id");
        String bt = (String) jsonRequest.getData().get("bt");
        String yyxtDm = (String) jsonRequest.getData().get("yyxt");
        String jbms = (String) jsonRequest.getData().get("jbms");
        String jbnr = (String) jsonRequest.getData().get("jbnr");

        if (StringUtils.isEmpty(bt) || StringUtils.isEmpty(yyxtDm) || StringUtils.isEmpty(jbms) || StringUtils.isEmpty(jbnr)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        } else if (bt.trim().length() < 15) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("标题至少15个字描述");
            return jsonResponse;
        } else if (bt.trim().length() > 200) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("标题不能超过200个字描述");
            return jsonResponse;
        } else if (jbms.trim().length() < 20) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("脚本描述至少20个字描述");
            return jsonResponse;
        } else if (jbms.trim().length() > 4000) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("脚本描述不能超过4000个字描述");
            return jsonResponse;
        } else if (jbnr.trim().length() < 20) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("脚本内容至少20个字描述");
            return jsonResponse;
        } else if (jbnr.trim().length() > 50000) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("脚本内容不能超过50000个字描述");
            return jsonResponse;
        } else if (!checkJbnr(jbnr.trim())) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("脚本内容不合法");
            return jsonResponse;
        }


        Ywjb ywjb = new Ywjb();
        ywjb.setBt(bt);
        ywjb.setMs(jbms);
        ywjb.setYyxtDm(yyxtDm);
        ywjb.setJbnr(jbnr);
        ywjb.setBmzbId(loginInfo.getBmzbId());
        if (StringUtils.isEmpty(id)) {
            ywjb.setId(ApplicationUtil.createDBID());
            ywjb.setLrry(loginInfo.getYhId());
            ywjb.setLrsj(DateUtil.getNowSqlDate());
            ywjbMapper.insert(ywjb);
        } else {
            ywjb.setId(id);
            ywjb.setXgry(loginInfo.getYhId());
            ywjb.setXgsj(DateUtil.getNowTimestamp());
            ywjbMapper.updateByPrimaryKeySelective(ywjb);
        }
        return jsonResponse;
    }


    private JsonResponse delYwjb(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String id = (String) jsonRequest.getData().get("id");
        if (!StringUtils.isEmpty(id)) {
            ywjbMapper.deleteByPrimaryKey(id);
        }
        return jsonResponse;
    }

    private JsonResponse uploadYwjb(JsonRequest<MultipartFile> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        InputStream is = null;
        List<Object> data = null;
        try {
            is = jsonRequest.getData().getInputStream();
            data = EasyExcelFactory.read(is, new Sheet(1, 0));
        } catch (IOException e) {
            logger.error("读取运维脚本模板出错", e);
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

        List<Ywjb> ywjbs = new ArrayList<>();
        Ywjb ywjb;
        for (int i = 1; i < data.size(); i++) {
            ArrayList rows = (ArrayList) data.get(i);
            if (rows.size() < 4) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行数据不完整");
                return jsonResponse;
            } else if (rows.get(0) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"标题\"不能为空");
                return jsonResponse;
            } else if (String.valueOf(rows.get(0)).trim().length() < 15) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"标题\"至少15个字描述");
                return jsonResponse;
            } else if (String.valueOf(rows.get(0)).trim().length() > 200) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"标题\"不能超过200个字描述");
                return jsonResponse;
            } else if (rows.get(1) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"应用系统\"不能为空");
                return jsonResponse;
            } else if (rows.get(2) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"脚本描述\"不能为空");
                return jsonResponse;
            } else if (String.valueOf(rows.get(2)).trim().length() < 20) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"脚本描述\"至少20个字描述");
                return jsonResponse;
            } else if (String.valueOf(rows.get(2)).trim().length() > 4000) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"脚本描述\"不能超过4000个字描述");
                return jsonResponse;
            } else if (rows.get(3) == null) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"脚本内容\"不能为空");
                return jsonResponse;
            } else if (String.valueOf(rows.get(3)).trim().length() < 20) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"脚本内容\"至少20个字描述");
                return jsonResponse;
            } else if (String.valueOf(rows.get(3)).trim().length() > 50000) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"脚本内容\"不能超过50000个字描述");
                return jsonResponse;
            } else if (!checkJbnr(String.valueOf(rows.get(3)).trim())) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("脚本内容不合法");
                return jsonResponse;
            }

            YyxtCriteria yyxtCriteria = new YyxtCriteria();
            YyxtCriteria.Criteria criteria = yyxtCriteria.createCriteria();
            criteria.andMcEqualTo((String) rows.get(1));
            List<Yyxt> yyxts = yyxtMapper.selectByExample(yyxtCriteria);
            if (yyxts.size() == 0) {
                jsonResponse.setCode("-1");
                jsonResponse.setMsg("第【" + (i + 1) + "】行\"应用系统\"系统不存在");
                return jsonResponse;
            }

            ywjb = new Ywjb();
            ywjb.setBt((String) rows.get(0));
            ywjb.setYyxtDm(yyxts.get(0).getDm());
            ywjb.setMs((String) rows.get(2));
            ywjb.setJbnr((String) rows.get(3));
            ywjb.setBmzbId(loginInfo.getBmzbId());
            ywjb.setId(ApplicationUtil.createDBID());
            ywjb.setLrry(loginInfo.getYhId());
            ywjb.setLrsj(DateUtil.getNowSqlDate());
            ywjbs.add(ywjb);
        }

        ywjbMapper.insertBatch(ywjbs);
        jsonResponse.setMsg("上传成功");
        return jsonResponse;
    }

    private boolean checkJbnr(String jbnr) {
        jbnr = jbnr.trim().toUpperCase();
        if (!jbnr.contains("INSERT") && !jbnr.contains("DELETE") && !jbnr.contains("UPDATE") && !jbnr.contains("SELECT")) {
            return false;
        }
        return true;
    }

}
