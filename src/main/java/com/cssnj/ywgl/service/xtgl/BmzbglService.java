package com.cssnj.ywgl.service.xtgl;

import com.cssnj.ywgl.domain.dept.Dept;
import com.cssnj.ywgl.domain.dept.DeptMapper;
import com.cssnj.ywgl.domain.user.User;
import com.cssnj.ywgl.domain.user.UserMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.dept.DeptVo;
import com.cssnj.ywgl.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/27 12:52
 */
@Service
public class BmzbglService extends BaseService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getBmzbxx".equals(jsonRequest.getHandle())) {
            return getBmzbxx(jsonRequest);
        } else if ("loadBmzbxxs".equals(jsonRequest.getHandle())) {
            return loadBmzbxxs(jsonRequest);
        } else if ("saveBmzbxx".equals(jsonRequest.getHandle())) {
            return saveBmzbxx(jsonRequest);
        } else if ("delBmzbxx".equals(jsonRequest.getHandle())) {
            return delBmzbxx(jsonRequest);
        } else if ("loadYhxxs".equals(jsonRequest.getHandle())) {
            return loadYhxxs(jsonRequest);
        } else if ("delBmzbyh".equals(jsonRequest.getHandle())) {
            return delBmzbyh(jsonRequest);
        }
        return null;
    }

    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
//        JsonResponse<PageInfo> jsonResponse = new JsonResponse<>();
//        int page = (Integer) jsonRequest.getData().get("page");
//        int rows = (Integer) jsonRequest.getData().get("rows");
//
//        rows = rows == 0 ? 10 : rows;
//        int offset = page == 0 ? 0 : (page - 1) * rows;
//
//        DeptCriteria deptCriteria = new DeptCriteria();
//        int count = deptMapper.countByExample(deptCriteria);
//        List<DeptVo> list = deptMapper.selectByPage(loginInfo.getYhId(), null, null, offset, rows);
//
//        PageInfo pageInfo = new PageInfo();
//        pageInfo.setRows(rows);
//        pageInfo.setCount(count);
//        pageInfo.setPage(page);
//        pageInfo.setData(list);
//        jsonResponse.setData(pageInfo);


        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<DeptVo> list = deptMapper.selectForList();
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse getBmzbxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        Dept dept = new Dept();
        if (!StringUtils.isEmpty(id)) {
            dept = deptMapper.selectByPrimaryKey(id);
        }
        jsonResponse.getData().put("bmzbxx", dept);
        return jsonResponse;
    }

    private JsonResponse loadBmzbxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<DeptVo> list = deptMapper.selectForEdit();
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse saveBmzbxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        String mc = (String) jsonRequest.getData().get("mc");
        String ms = (String) jsonRequest.getData().get("ms");
        String xh = (String) jsonRequest.getData().get("xh");
        String sjbmzbId = (String) jsonRequest.getData().get("sjbmzbId");
        String yxbz = (String) jsonRequest.getData().get("yxbz");


        if (StringUtils.isEmpty(mc) || StringUtils.isEmpty(sjbmzbId) || StringUtils.isEmpty(yxbz)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        Dept dept = new Dept();
        dept.setMc(mc);
        dept.setMs(ms);
        if (!StringUtils.isEmpty(xh)) {
            dept.setXh(Integer.parseInt(xh));
        }
        dept.setSjbmzbId(sjbmzbId);
        dept.setYxbz(yxbz);

        if (StringUtils.isEmpty(id)) {
            dept.setId(ApplicationUtil.createDBID());
            dept.setLrry(loginInfo.getYhId());
            dept.setLrsj(DateUtil.getNowTimestamp());
            deptMapper.insert(dept);
        } else {
            dept.setId(id);
            dept.setXgry(loginInfo.getYhId());
            dept.setXgsj(DateUtil.getNowTimestamp());
            deptMapper.updateByPrimaryKeySelective(dept);
        }
        return jsonResponse;
    }


    private JsonResponse delBmzbxx(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
//        String id = (String) jsonRequest.getData().get("id");
//        if (!StringUtils.isEmpty(id)) {
//            deptMapper.deleteByPrimaryKey(id);
//        }
        return jsonResponse;
    }

    private JsonResponse loadYhxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String bmzbId = (String) jsonRequest.getData().get("id");
        String xm = (String) jsonRequest.getData().get("xm");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = userMapper.countForBmzbgl(xm, bmzbId);
        List<UserVo> List = userMapper.selectForBmzbgl(xm, bmzbId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", List);
        return jsonResponse;
    }

    private JsonResponse delBmzbyh(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String bmzbId = (String) jsonRequest.getData().get("id");
        String yhId = (String) jsonRequest.getData().get("yhId");

        if (StringUtils.isEmpty(bmzbId) || StringUtils.isEmpty(yhId)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }
        User user = userMapper.selectByPrimaryKey(yhId);
        user.setBmzbId("");
        user.setXgry(loginInfo.getYhId());
        user.setXgsj(DateUtil.getNowTimestamp());
        userMapper.updateByPrimaryKey(user);
        return jsonResponse;
    }
}
