package com.cssnj.ywgl.service.xtgl;

import com.cssnj.ywgl.domain.dept.DeptMapper;
import com.cssnj.ywgl.domain.user.User;
import com.cssnj.ywgl.domain.user.UserCriteria;
import com.cssnj.ywgl.domain.user.UserMapper;
import com.cssnj.ywgl.domain.xtqx.UserRole;
import com.cssnj.ywgl.domain.xtqx.UserRoleCriteria;
import com.cssnj.ywgl.domain.xtqx.UserRoleMapper;
import com.cssnj.ywgl.domain.xtzy.RoleMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.dept.DeptVo;
import com.cssnj.ywgl.vo.user.UserVo;
import com.cssnj.ywgl.vo.xtzy.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/26 21:00
 */
@Service
public class YhglService extends BaseService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getYhxx".equals(jsonRequest.getHandle())) {
            return getYhxx(jsonRequest);
        } else if ("loadBmzbs".equals(jsonRequest.getHandle())) {
            return loadBmzbs(jsonRequest);
        } else if ("saveYhxx".equals(jsonRequest.getHandle())) {
            return saveYhxx(jsonRequest);
        } else if ("delYhxx".equals(jsonRequest.getHandle())) {
            return delYhxx(jsonRequest);
        } else if ("loadJsxxs".equals(jsonRequest.getHandle())) {
            return loadJsxxs(jsonRequest);
        } else if ("saveYhjs".equals(jsonRequest.getHandle())) {
            return saveYhjs(jsonRequest);
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

        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria criteria = userCriteria.createCriteria();
        if (!StringUtils.isEmpty(xm)) {
            criteria.andXmLike("%" + xm + "%");
        }
        if (!StringUtils.isEmpty(bmzbId)) {
            criteria.andBmzbIdEqualTo(bmzbId);
        }
        int count = userMapper.countByExample(userCriteria);
        List<UserVo> list = userMapper.selectForList(loginInfo.getYhId(), xm, bmzbId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }


    private JsonResponse getYhxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        User user = new User();
        if (!StringUtils.isEmpty(id)) {
            user = userMapper.selectByPrimaryKey(id);
        }
        jsonResponse.getData().put("yhxx", user);
        return jsonResponse;
    }

    private JsonResponse loadBmzbs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<DeptVo> list = deptMapper.selectForYhxx();
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse saveYhxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        String xm = (String) jsonRequest.getData().get("xm");
        String xb = (String) jsonRequest.getData().get("xb");
        String csrq = (String) jsonRequest.getData().get("csrq");
        String yddh = (String) jsonRequest.getData().get("yddh");
        String gddh = (String) jsonRequest.getData().get("gddh");
        String dzyx = (String) jsonRequest.getData().get("dzyx");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String yxbz = (String) jsonRequest.getData().get("yxbz");

        if (StringUtils.isEmpty(xm) || StringUtils.isEmpty(bmzbId) || StringUtils.isEmpty(yxbz)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        User user = new User();
        user.setXm(xm);
        user.setXb(xb);
        if (!StringUtils.isEmpty(csrq)) {
            user.setCsrq(DateUtil.parseStringToUtil(csrq, "yyyy-MM-dd"));
        }
        user.setYddh(yddh);
        user.setGddh(gddh);
        user.setDzyx(dzyx);
        user.setBmzbId(bmzbId);
        user.setYxbz(yxbz);

        if (StringUtils.isEmpty(id)) {
            user.setId(ApplicationUtil.createDBID());
            user.setLrry(loginInfo.getYhId());
            user.setLrsj(DateUtil.getNowTimestamp());
            userMapper.insert(user);
        } else {
            user.setId(id);
            user.setXgry(loginInfo.getYhId());
            user.setXgsj(DateUtil.getNowTimestamp());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return jsonResponse;
    }


    private JsonResponse delYhxx(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
//        String id = (String) jsonRequest.getData().get("id");
//        if (!StringUtils.isEmpty(id)) {
//            userMapper.deleteByPrimaryKey(id);
//        }
        return jsonResponse;
    }

    private JsonResponse loadJsxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        List<RoleVo> list = roleMapper.selectForYhsq(loginInfo.getYhId(), id);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse saveYhjs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String yhId = (String) jsonRequest.getData().get("id");
        String jsIds = (String) jsonRequest.getData().get("jsIds");

        if (StringUtils.isEmpty(yhId)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }
        List<UserRole> userRoles = new ArrayList<>();
        String[] jsArray = jsIds.split(",");
        UserRole userRole;
        for (int i = 0; i < jsArray.length; i++) {
            userRole = new UserRole();
            userRole.setId(ApplicationUtil.createDBID());
            userRole.setYhId(yhId);
            userRole.setJsId(jsArray[i]);
            userRole.setLrry(loginInfo.getYhId());
            userRole.setLrsj(DateUtil.getNowTimestamp());
            userRoles.add(userRole);
        }
        if (userRoles.size() > 0) {
            UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
            UserRoleCriteria.Criteria criteria = userRoleCriteria.createCriteria();
            criteria.andYhIdEqualTo(yhId);
            userRoleMapper.deleteByExample(userRoleCriteria);
            userRoleMapper.insertBatch(userRoles);
        }
        return jsonResponse;
    }
}
