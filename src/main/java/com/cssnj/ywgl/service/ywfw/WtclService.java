package com.cssnj.ywgl.service.ywfw;

import com.cssnj.ywgl.domain.ywfw.Wthf;
import com.cssnj.ywgl.domain.ywfw.WthfMapper;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/2/14 09:14
 */
@Service
public class WtclService extends BaseService {
    private static final Logger logger = LoggerFactory.getLogger(WtclService.class);

    @Autowired
    private WtxxMapper wtxxMapper;
    @Autowired
    private WthfMapper wthfMapper;


    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getWtxx".equals(jsonRequest.getHandle())) {
            return getWtxx(jsonRequest);
        } else if ("saveReply".equals(jsonRequest.getHandle())) {
            return saveReply(jsonRequest);
        }
        return null;
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
//        List<String> zts = new ArrayList<>();
//        zts.add("01");
//        zts.add("02");
//        criteria.andWtztDmIn(zts);
//        int count = wtxxMapper.countByExample(wtxxCriteria);
        int count = wtxxMapper.countForWtclList(loginInfo.getYhId(), loginInfo.getBmzbId(), bt, wtlxDm, yyxtDm, ywmkDm);
        List<WtxxVo> list = wtxxMapper.selectForWtclList(loginInfo.getYhId(), loginInfo.getBmzbId(), bt, wtlxDm, yyxtDm, ywmkDm, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }


    private JsonResponse getWtxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String wtxxId = (String) jsonRequest.getData().get("id");
        WtxxVo wtxxVo = new WtxxVo();
        List<WthfVo> wthfList = new ArrayList<>();
        if (!StringUtils.isEmpty(wtxxId)) {
            wtxxVo = wtxxMapper.selectByPk(wtxxId);
            wthfList = wthfMapper.selectForWtclList(wtxxId);
        }
        jsonResponse.getData().put("wtxx", wtxxVo);
        jsonResponse.getData().put("wthfList", wthfList);
        return jsonResponse;
    }


    private JsonResponse saveReply(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String id = (String) jsonRequest.getData().get("id");
        String nr = (String) jsonRequest.getData().get("nr");
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(nr)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        WtxxVo wtxxVo = wtxxMapper.selectByPk(id);
        if ("04".equals(wtxxVo.getWtztDm())) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("问题已被解决，此次回复不做提交");
            return jsonResponse;
        }

        Wthf wthf = new Wthf();
        wthf.setId(ApplicationUtil.createDBID());
        wthf.setNr(nr);
        wthf.setWtxxId(id);
        wthf.setBmzbId(loginInfo.getBmzbId());
        wthf.setLrry(loginInfo.getYhId());
        wthf.setLrsj(DateUtil.getNowTimestamp());
        wthfMapper.insert(wthf);
        return jsonResponse;
    }

}
