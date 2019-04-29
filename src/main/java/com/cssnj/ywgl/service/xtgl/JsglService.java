package com.cssnj.ywgl.service.xtgl;

import com.cssnj.ywgl.domain.user.UserMapper;
import com.cssnj.ywgl.domain.xtqx.*;
import com.cssnj.ywgl.domain.xtzy.ResourceMapper;
import com.cssnj.ywgl.domain.xtzy.Role;
import com.cssnj.ywgl.domain.xtzy.RoleMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.vo.user.UserVo;
import com.cssnj.ywgl.vo.xtzy.ResourceVo;
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
 * @Date: 2019/3/22 11:14
 */
@Service
public class JsglService extends BaseService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getJsxx".equals(jsonRequest.getHandle())) {
            return getJsxx(jsonRequest);
        } else if ("loadJsxxs".equals(jsonRequest.getHandle())) {
            return loadJsxxs(jsonRequest);
        } else if ("saveJsxx".equals(jsonRequest.getHandle())) {
            return saveJsxx(jsonRequest);
        } else if ("delJsxx".equals(jsonRequest.getHandle())) {
            return delJsxx(jsonRequest);
        } else if ("loadGncds".equals(jsonRequest.getHandle())) {
            return loadGncds(jsonRequest);
        } else if ("saveJsgncd".equals(jsonRequest.getHandle())) {
            return saveJsgncd(jsonRequest);
        } else if ("loadYsqYhxxs".equals(jsonRequest.getHandle())) {
            return loadYsqYhxxs(jsonRequest);
        } else if ("loadWsqYhxxs".equals(jsonRequest.getHandle())) {
            return loadWsqYhxxs(jsonRequest);
        } else if ("saveJsyh".equals(jsonRequest.getHandle())) {
            return saveJsyh(jsonRequest);
        } else if ("delJsyh".equals(jsonRequest.getHandle())) {
            return delJsyh(jsonRequest);
        }
        return null;
    }

    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<RoleVo> list = roleMapper.selectForList(loginInfo.getYhId());
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse getJsxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        Role role = new Role();
        if (!StringUtils.isEmpty(id)) {
            role = roleMapper.selectByPrimaryKey(id);
        }
        jsonResponse.getData().put("jsxx", role);
        return jsonResponse;
    }

    private JsonResponse loadJsxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<RoleVo> list = roleMapper.selectForList(loginInfo.getYhId());
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse saveJsxx(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        String mc = (String) jsonRequest.getData().get("mc");
        String ms = (String) jsonRequest.getData().get("ms");
        String qxbs = (String) jsonRequest.getData().get("qxbs");
        String xh = (String) jsonRequest.getData().get("xh");
        String sjjsId = (String) jsonRequest.getData().get("sjjsId");
        String yxbz = (String) jsonRequest.getData().get("yxbz");

        if (StringUtils.isEmpty(mc) || StringUtils.isEmpty(sjjsId) || StringUtils.isEmpty(yxbz)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        Role role = new Role();
        role.setMc(mc);
        role.setMs(ms);
        role.setQxbs(qxbs);
        if (!StringUtils.isEmpty(xh)) {
            role.setXh(Integer.parseInt(xh));
        }
        role.setSjjsId(sjjsId);
        role.setYxbz(yxbz);

        if (StringUtils.isEmpty(id)) {
            role.setId(ApplicationUtil.createDBID());
            role.setLrry(loginInfo.getYhId());
            role.setLrsj(DateUtil.getNowTimestamp());
            roleMapper.insert(role);
        } else {
            role.setId(id);
            role.setXgry(loginInfo.getYhId());
            role.setXgsj(DateUtil.getNowTimestamp());
            roleMapper.updateByPrimaryKeySelective(role);
        }
        return jsonResponse;
    }

    private JsonResponse delJsxx(JsonRequest jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
//        String id = (String) jsonRequest.getData().get("id");
//        if (!StringUtils.isEmpty(id)) {
//            roleMapper.deleteByPrimaryKey(id);
//        }
        return jsonResponse;
    }

    private JsonResponse loadGncds(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        List<ResourceVo> list = resourceMapper.selectForJsfp(id);
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }

    private JsonResponse saveJsgncd(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String jsId = (String) jsonRequest.getData().get("id");
        String gncd_cd = (String) jsonRequest.getData().get("gncd_cd");
        String gncd_gn = (String) jsonRequest.getData().get("gncd_gn");

        if (StringUtils.isEmpty(jsId) || (StringUtils.isEmpty(gncd_cd) && !StringUtils.isEmpty(gncd_gn))) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        List<RoleMenu> roleMenus = new ArrayList<>();
        List<RolePermission> rolePermissions = new ArrayList<>();
        if (!StringUtils.isEmpty(gncd_cd)) {
            String[] cdIds = gncd_cd.split(",");
            RoleMenu roleMenu;
            for (int i = 0; i < cdIds.length; i++) {
                roleMenu = new RoleMenu();
                roleMenu.setId(ApplicationUtil.createDBID());
                roleMenu.setJsId(jsId);
                roleMenu.setGncdId(cdIds[i]);
                roleMenu.setLrry(loginInfo.getYhId());
                roleMenu.setLrsj(DateUtil.getNowTimestamp());
                roleMenus.add(roleMenu);
            }
        }
        if (!StringUtils.isEmpty(gncd_gn)) {
            String[] gnIds = gncd_gn.split(",");
            RolePermission rolePermission;
            for (int i = 0; i < gnIds.length; i++) {
                rolePermission = new RolePermission();
                rolePermission.setId(ApplicationUtil.createDBID());
                rolePermission.setJsId(jsId);
                rolePermission.setGncdId(gnIds[i]);
                rolePermission.setLrry(loginInfo.getYhId());
                rolePermission.setLrsj(DateUtil.getNowTimestamp());
                rolePermissions.add(rolePermission);
            }
        }
        if (roleMenus.size() > 0) {
            RoleMenuCriteria roleMenuCriteria = new RoleMenuCriteria();
            RoleMenuCriteria.Criteria criteria = roleMenuCriteria.createCriteria();
            criteria.andJsIdEqualTo(jsId);
            roleMenuMapper.deleteByExample(roleMenuCriteria);
            roleMenuMapper.insertBatch(roleMenus);
        }
        if (rolePermissions.size() > 0) {
            RolePermissionCriteria rolePermissionCriteria = new RolePermissionCriteria();
            RolePermissionCriteria.Criteria criteria1 = rolePermissionCriteria.createCriteria();
            criteria1.andJsIdEqualTo(jsId);
            rolePermissionMapper.deleteByExample(rolePermissionCriteria);
            rolePermissionMapper.insertBatch(rolePermissions);
        }
        return jsonResponse;
    }

    private JsonResponse loadYsqYhxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String jsId = (String) jsonRequest.getData().get("id");
        String xm = (String) jsonRequest.getData().get("xm");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = userMapper.countForJsysq(xm, bmzbId, jsId);
        List<UserVo> List = userMapper.selectForJsysq(xm, bmzbId, jsId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", List);
        return jsonResponse;
    }

    private JsonResponse loadWsqYhxxs(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String jsId = (String) jsonRequest.getData().get("id");
        String xm = (String) jsonRequest.getData().get("xm");
        String bmzbId = (String) jsonRequest.getData().get("bmzbId");
        String page = (String) jsonRequest.getData().get("page");
        String limit = (String) jsonRequest.getData().get("limit");

        int rows = StringUtils.isEmpty(limit) || "null".equals(limit) ? 10 : Integer.parseInt(limit);
        int offset = StringUtils.isEmpty(page) || "null".equals(page) ? 0 : (Integer.parseInt(page) - 1) * rows;

        int count = userMapper.countForJswsq(xm, bmzbId, jsId);
        List<UserVo> List = userMapper.selectForJswsq(xm, bmzbId, jsId, offset, rows);
        jsonResponse.getData().put("count", count);
        jsonResponse.getData().put("list", List);
        return jsonResponse;
    }


    private JsonResponse saveJsyh(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String jsId = (String) jsonRequest.getData().get("id");
        String jsyh = (String) jsonRequest.getData().get("jsyh");

        if (StringUtils.isEmpty(jsId) || StringUtils.isEmpty(jsyh)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        List<UserRole> userRoles = new ArrayList<>();
        String[] yhIds = jsyh.split(",");
        UserRole userRole;
        for (int i = 0; i < yhIds.length; i++) {
            userRole = new UserRole();
            userRole.setId(ApplicationUtil.createDBID());
            userRole.setYhId(yhIds[i]);
            userRole.setJsId(jsId);
            userRole.setLrry(loginInfo.getYhId());
            userRole.setLrsj(DateUtil.getNowTimestamp());
            userRoles.add(userRole);
        }
        if (userRoles.size() > 0) {
            userRoleMapper.insertBatch(userRoles);
        }
        return jsonResponse;
    }

    private JsonResponse delJsyh(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse jsonResponse = new JsonResponse();
        String jsId = (String) jsonRequest.getData().get("id");
        String yhId = (String) jsonRequest.getData().get("yhId");

        if (StringUtils.isEmpty(jsId) || StringUtils.isEmpty(yhId)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }
        UserRoleCriteria userRoleCriteria = new UserRoleCriteria();
        UserRoleCriteria.Criteria criteria = userRoleCriteria.createCriteria();
        criteria.andYhIdEqualTo(yhId);
        criteria.andJsIdEqualTo(jsId);
        userRoleMapper.deleteByExample(userRoleCriteria);
        return jsonResponse;
    }

}
