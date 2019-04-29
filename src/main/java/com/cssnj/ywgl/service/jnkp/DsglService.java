package com.cssnj.ywgl.service.jnkp;

import com.cssnj.ywgl.domain.dept.DeptMapper;
import com.cssnj.ywgl.domain.jnkp.Dsxx;
import com.cssnj.ywgl.domain.jnkp.DsxxMapper;
import com.cssnj.ywgl.domain.jnkp.Xsxx;
import com.cssnj.ywgl.domain.jnkp.XsxxMapper;
import com.cssnj.ywgl.domain.user.UserMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.dept.DeptVo;
import com.cssnj.ywgl.vo.jnkp.DsxxVo;
import com.cssnj.ywgl.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019-04-24 21:35
 */
@Service
public class DsglService extends BaseService {

    @Autowired
    private DsxxMapper dsxxMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private XsxxMapper xsxxMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getDsxx".equals(jsonRequest.getHandle())) {
            return getDsxx(jsonRequest);
        } else if ("loadBmzbs".equals(jsonRequest.getHandle())) {
            return loadBmzbs(jsonRequest);
        } else if ("loadYhxxs".equals(jsonRequest.getHandle())) {
            return loadYhxxs(jsonRequest);
        } else if ("getDsxx".equals(jsonRequest.getHandle())) {
            return getDsxx(jsonRequest);
        } else if ("saveDsxx".equals(jsonRequest.getHandle())) {
            return saveDsxx(jsonRequest);
        } else if ("updateDsxx".equals(jsonRequest.getHandle())) {
            return updateDsxx(jsonRequest);
        } else if ("loadYfpYhxxs".equals(jsonRequest.getHandle())) {
            return loadYfpYhxxs(jsonRequest);
        } else if ("loadWfpYhxxs".equals(jsonRequest.getHandle())) {
            return loadWfpYhxxs(jsonRequest);
        } else if ("saveDsxs".equals(jsonRequest.getHandle())) {
            return saveDsxs(jsonRequest);
        } else if ("delDsxs".equals(jsonRequest.getHandle())) {
            return delDsxs(jsonRequest);
        }
        return null;
    }


    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String xm = (String) jsonRequest.getData().get("xm");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = dsxxMapper.countForList(xm, bmzbId);
        List<DsxxVo> list = dsxxMapper.selectForList(xm, bmzbId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse getDsxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        DsxxVo dsxxVo = new DsxxVo();
        if (!StringUtils.isEmpty(id)) {
            dsxxVo = dsxxMapper.selectByPk(id);
        }

        jsonResponse.getData().put("dsxx", dsxxVo);
        return jsonResponse;
    }

    private JsonResponse loadBmzbs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<DeptVo> list = deptMapper.selectForDsxx();
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse loadYhxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String xm = (String) jsonRequest.getData().get("xm");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = userMapper.countForDsgl(xm, bmzbId);
        List<UserVo> List = userMapper.selectForDsgl(xm, bmzbId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", List);
        return jsonResponse;
    }


    private JsonResponse saveDsxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String dsId = (String) jsonRequest.getData().get("dsId");
        String yhId = (String) jsonRequest.getData().get("yhId");
        String yxbz = (String) jsonRequest.getData().get("yxbz");

        if (StringUtils.isEmpty(yhId)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        Dsxx dsxx = new Dsxx();
        if (StringUtils.isEmpty(dsId)) {
            dsxx.setId(ApplicationUtil.createDBID());
            dsxx.setYhId(yhId);
            dsxx.setYxbz("Y");
            dsxx.setLrry(loginInfo.getYhId());
            dsxx.setLrsj(DateUtil.getNowTimestamp());
            dsxxMapper.insert(dsxx);
        } else {
            dsxx.setId(dsId);
            dsxx.setYxbz(yxbz);
            dsxx.setXgry(loginInfo.getYhId());
            dsxx.setXgsj(DateUtil.getNowTimestamp());
            dsxxMapper.updateByPrimaryKeySelective(dsxx);
        }
        return jsonResponse;
    }

    private JsonResponse updateDsxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String dsId = (String) jsonRequest.getData().get("id");
        String yxbz = (String) jsonRequest.getData().get("yxbz");

        if (StringUtils.isEmpty(dsId) || StringUtils.isEmpty(yxbz)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        Dsxx dsxx = new Dsxx();
        dsxx.setId(dsId);
        dsxx.setYxbz(yxbz);
        dsxx.setXgry(loginInfo.getYhId());
        dsxx.setXgsj(DateUtil.getNowTimestamp());
        dsxxMapper.updateByPrimaryKeySelective(dsxx);

        return jsonResponse;
    }

    private JsonResponse loadYfpYhxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String dsId = (String) jsonRequest.getData().get("id");
        String xm = (String) jsonRequest.getData().get("xm");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = userMapper.countForXsyfp(xm, bmzbId, dsId);
        List<UserVo> List = userMapper.selectForXsyfp(xm, bmzbId, dsId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", List);
        return jsonResponse;
    }

    private JsonResponse loadWfpYhxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String dsId = (String) jsonRequest.getData().get("id");
        String dsYhId = (String) jsonRequest.getData().get("dsYhId");
        String xm = (String) jsonRequest.getData().get("xm");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = userMapper.countForXswfp(xm, bmzbId, dsId, dsYhId);
        List<UserVo> List = userMapper.selectForXswfp(xm, bmzbId, dsId, dsYhId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", List);
        return jsonResponse;
    }

    private JsonResponse saveDsxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String dsId = (String) jsonRequest.getData().get("id");
        String dsxs = (String) jsonRequest.getData().get("dsxs");

        if (StringUtils.isEmpty(dsId) || StringUtils.isEmpty(dsxs)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        List<Xsxx> xsxxes = new ArrayList<>();
        String[] yhIds = dsxs.split(",");
        Xsxx xsxx;
        for (int i = 0; i < yhIds.length; i++) {
            xsxx = new Xsxx();
            xsxx.setId(ApplicationUtil.createDBID());
            xsxx.setDsId(dsId);
            xsxx.setYhId(yhIds[i]);
            xsxx.setYxbz("Y");
            xsxx.setLrry(loginInfo.getYhId());
            xsxx.setLrsj(DateUtil.getNowTimestamp());
            xsxxes.add(xsxx);
        }
        if (xsxxes.size() > 0) {
            xsxxMapper.insertBatch(xsxxes);
        }
        return jsonResponse;
    }

    private JsonResponse delDsxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String dsId = (String) jsonRequest.getData().get("id");
        String yhId = (String) jsonRequest.getData().get("yhId");

        if (StringUtils.isEmpty(dsId) || StringUtils.isEmpty(yhId)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        Xsxx xsxx = new Xsxx();
        xsxx.setDsId(dsId);
        xsxx.setYhId(yhId);
        xsxx.setYxbz("N");
        xsxx.setXgry(loginInfo.getYhId());
        xsxx.setXgsj(DateUtil.getNowTimestamp());
        xsxxMapper.updateByDsxsSelective(xsxx);

        return jsonResponse;
    }

}
