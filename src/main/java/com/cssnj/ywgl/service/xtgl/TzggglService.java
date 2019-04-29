package com.cssnj.ywgl.service.xtgl;

import com.cssnj.ywgl.domain.xtzy.Notice;
import com.cssnj.ywgl.domain.xtzy.NoticeCriteria;
import com.cssnj.ywgl.domain.xtzy.NoticeMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.xtzy.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/4/9 22:08
 */
@Service
public class TzggglService extends BaseService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getTzgg".equals(jsonRequest.getHandle())) {
            return getTzgg(jsonRequest);
        } else if ("saveTzgg".equals(jsonRequest.getHandle())) {
            return saveTzgg(jsonRequest);
        }
        return null;
    }


    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String bt = (String) jsonRequest.getData().get("bt");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;


        NoticeCriteria noticeCriteria = new NoticeCriteria();
        NoticeCriteria.Criteria criteria = noticeCriteria.createCriteria();
        Map params = new HashMap();
        if (!StringUtils.isEmpty(bt)) {
            criteria.andBtLike("%" + bt + "%");
            params.put("bt", bt);
        }
        int count = noticeMapper.countByExample(noticeCriteria);
        params.put("offset", offset);
        params.put("rows", rows);
        List<NoticeVo> list = noticeMapper.selectForList(params);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse getTzgg(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        NoticeVo noticeVo = new NoticeVo();
        if (!StringUtils.isEmpty(id)) {
            noticeVo = noticeMapper.selectByPk(id);
        }
        jsonResponse.getData().put("notice", noticeVo);
        return jsonResponse;
    }

    private JsonResponse saveTzgg(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        String bt = (String) jsonRequest.getData().get("bt");
        String nr = (String) jsonRequest.getData().get("nr");
        String gqsj = (String) jsonRequest.getData().get("gqsj");
        String yxbz = (String) jsonRequest.getData().get("yxbz");

        if (StringUtils.isEmpty(bt) || StringUtils.isEmpty(nr) || StringUtils.isEmpty(yxbz)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        Notice notice = new Notice();
        notice.setBt(bt);
        notice.setNr(nr);
        notice.setGqsj(DateUtil.parseStringToUtil(gqsj, "yyyy-MM-dd"));
        notice.setYxbz(yxbz);

        if (StringUtils.isEmpty(id)) {
            notice.setId(ApplicationUtil.createDBID());
            notice.setLrry(loginInfo.getYhId());
            notice.setLrsj(DateUtil.getNowTimestamp());
            noticeMapper.insert(notice);
        } else {
            notice.setId(id);
            notice.setXgry(loginInfo.getYhId());
            notice.setXgsj(DateUtil.getNowTimestamp());
            noticeMapper.updateByPrimaryKeySelective(notice);
        }
        return jsonResponse;
    }

}
