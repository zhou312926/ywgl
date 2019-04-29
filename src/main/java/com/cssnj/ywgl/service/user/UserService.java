package com.cssnj.ywgl.service.user;

import com.cssnj.ywgl.domain.user.*;
import com.cssnj.ywgl.domain.xtqx.RolePermissionMapper;
import com.cssnj.ywgl.domain.xtqx.UserRoleMapper;
import com.cssnj.ywgl.domain.xtzy.NoticeMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.dto.user.LoginInfo;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.utils.MD5Util;
import com.cssnj.ywgl.vo.user.UserVo;
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
 * @Date: 2019/1/23 18:54
 */
@Service
public class UserService extends BaseService {

    @Autowired
    private LoginAccountMapper loginAccountMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private UserNoticeMapper userNoticeMapper;


    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("queryLoginInfo".equals(jsonRequest.getHandle())) {
            return queryAccount(jsonRequest);
        } else if ("queryUserPermission".equals(jsonRequest.getHandle())) {
            return queryUserPermission(jsonRequest);
        } else if ("getUserInfo".equals(jsonRequest.getHandle())) {
            return getUserInfo(jsonRequest);
        } else if ("saveUserInfo".equals(jsonRequest.getHandle())) {
            return saveUserInfo(jsonRequest);
        } else if ("savePassword".equals(jsonRequest.getHandle())) {
            return savePassword(jsonRequest);
        }else if ("getTzgg".equals(jsonRequest.getHandle())) {
            return getTzgg(jsonRequest);
        } else if ("saveYhTzgg".equals(jsonRequest.getHandle())) {
            return saveYhTzgg(jsonRequest);
        }
        return null;
    }

    private JsonResponse queryAccount(JsonRequest<Map> jsonRequest) {
        JsonResponse<LoginInfo> jsonResponse = new JsonResponse<>();
        String dlzh = (String) jsonRequest.getData().get("dlzh");
        LoginInfo loginInfo = loginAccountMapper.selectForLogin(dlzh);
        jsonResponse.setData(loginInfo);
        return jsonResponse;
    }

    private JsonResponse queryUserPermission(JsonRequest<Map> jsonRequest) {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String yhId = (String) jsonRequest.getData().get("yhId");

        List<String> roles = userRoleMapper.selectForLogin(yhId);
        List<String> permissions = rolePermissionMapper.selectForlogin(yhId);

        Map map = new HashMap();
        map.put("roles", roles);
        map.put("permissions", permissions);
        jsonResponse.setData(map);
        return jsonResponse;
    }

    private JsonResponse getUserInfo(JsonRequest<Map> jsonRequest) {
        JsonResponse<UserVo> jsonResponse = new JsonResponse<>();
        UserVo userVo = new UserVo();
        userVo.setId(loginInfo.getYhId());
        userVo.setXm(loginInfo.getXm());
        userVo.setXb(loginInfo.getXb());
        userVo.setCsrq(loginInfo.getCsrq());
        userVo.setYddh(loginInfo.getYddh());
        userVo.setGddh(loginInfo.getGddh());
        userVo.setDzyx(loginInfo.getDzyx());
        userVo.setBmzbId(loginInfo.getBmzbId());
        userVo.setBmzbMc(loginInfo.getBmzbMc());
        jsonResponse.setData(userVo);
        return jsonResponse;
    }

    private JsonResponse saveUserInfo(JsonRequest<Map> jsonRequest) {
        JsonResponse jsonResponse = new JsonResponse();
        String id = (String) jsonRequest.getData().get("id");
//        String xm = (String) jsonRequest.getData().get("xm");
        String xb = (String) jsonRequest.getData().get("xb");
        String csrq = (String) jsonRequest.getData().get("csrq");
        String yddh = (String) jsonRequest.getData().get("yddh");
        String gddh = (String) jsonRequest.getData().get("gddh");
        String dzyx = (String) jsonRequest.getData().get("dzyx");

        if (StringUtils.isEmpty("id") || !id.equals(loginInfo.getYhId())) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }

        User user = new User();
        user.setId(id);
        user.setXb(xb);
        if (!StringUtils.isEmpty(csrq)) {
            user.setCsrq(DateUtil.parseStringToUtil(csrq, "yyyy-MM-dd"));

        }
        user.setYddh(yddh);
        user.setGddh(gddh);
        user.setDzyx(dzyx);
        user.setXgry(loginInfo.getYhId());
        user.setXgsj(DateUtil.getNowTimestamp());
        userMapper.updateByPrimaryKeySelective(user);
        loginInfo.setXb(user.getXb());
        loginInfo.setCsrq(DateUtil.parseUtilToString(user.getCsrq(), "yyyy-MM-dd"));
        loginInfo.setYddh(user.getYddh());
        loginInfo.setGddh(user.getGddh());
        loginInfo.setDzyx(user.getDzyx());
        return jsonResponse;
    }

    private JsonResponse savePassword(JsonRequest<Map> jsonRequest) {
        JsonResponse jsonResponse = new JsonResponse();
        String id = (String) jsonRequest.getData().get("id");
        String oldPassword = (String) jsonRequest.getData().get("oldPassword");
        String password = (String) jsonRequest.getData().get("password");

        if (StringUtils.isEmpty("id") || !id.equals(loginInfo.getYhId())) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }
        if (!loginInfo.getMm().equals(MD5Util.shiroMD5(oldPassword))) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("原密码错误");
            return jsonResponse;
        }

        LoginAccount loginAccount = new LoginAccount();
        loginAccount.setId(loginInfo.getZhId());
        loginAccount.setMm(MD5Util.shiroMD5(password));
        loginAccount.setXgry(loginInfo.getYhId());
        loginAccount.setXgsj(DateUtil.getNowTimestamp());
        loginAccountMapper.updateByPrimaryKeySelective(loginAccount);
        loginInfo.setMm(loginAccount.getMm());
        return jsonResponse;
    }

    private JsonResponse getTzgg(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<List> jsonResponse = new JsonResponse<>();
        List<NoticeVo> list = noticeMapper.selectByYhId(loginInfo.getYhId());
        if (list.size() == 0) {
            jsonResponse.setCode("-1");
        } else {
            jsonResponse.setData(list);
        }
        return jsonResponse;
    }

    private JsonResponse saveYhTzgg(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String tzggId = (String) jsonRequest.getData().get("id");
        if (StringUtils.isEmpty(tzggId)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        }
        UserNotice userNotice = new UserNotice();
        userNotice.setId(ApplicationUtil.createDBID());
        userNotice.setYhId(loginInfo.getYhId());
        userNotice.setTzggId(tzggId);
        userNotice.setQrbz("Y");
        userNotice.setLrry(loginInfo.getYhId());
        userNotice.setLrsj(DateUtil.getNowSqlDate());
        userNoticeMapper.insert(userNotice);
        return jsonResponse;
    }
}
