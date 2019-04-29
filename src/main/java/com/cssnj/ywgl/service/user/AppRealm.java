package com.cssnj.ywgl.service.user;

import com.cssnj.ywgl.constant.Constants;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.dto.user.CaptchaToken;
import com.cssnj.ywgl.dto.user.LoginInfo;
import com.cssnj.ywgl.exception.CaptchaException;
import com.cssnj.ywgl.exception.IncompleteUserException;
import com.cssnj.ywgl.service.facade.IService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/1/30 21:39
 */
public class AppRealm extends AuthorizingRealm {


    @Autowired
    private IService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        String username = (String) principalCollection.getPrimaryPrincipal();
        LoginInfo loginInfo = (LoginInfo) principalCollection.getPrimaryPrincipal();

        List<String> roles = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        try {
            JsonResponse<Map> jsonResponse = userService.execute(new JsonRequest("queryUserPermission", new HashMap<String, Object>() {{
                put("yhId", loginInfo.getYhId());
            }}));
            roles = (List<String>) jsonResponse.getData().get("roles");
            permissions = (List<String>) jsonResponse.getData().get("permissions");
        } catch (Exception e) {

        }
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(permissions);

//        for (Role role : roles) {
//            //添加角色
//            simpleAuthorizationInfo.addRole(role.getMc());
//        }
//        for (Permission permission : permissions) {
//            //添加权限
//            simpleAuthorizationInfo.addStringPermission(permission.getMc());
//        }
//        return simpleAuthorizationInfo;

        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
//        if (authenticationToken.getPrincipal() == null) {
//            return null;
//        }
//        //获取用户信息
//        String username = authenticationToken.getPrincipal().toString();


        CaptchaToken captchaToken = (CaptchaToken) authenticationToken;
        String vcode = (String) SecurityUtils.getSubject().getSession().getAttribute(Constants.CAPTCHA_SESSION_KEY);
        if (vcode == null || !vcode.equalsIgnoreCase(captchaToken.getCaptchaCode())) {//验证码错误
            throw new CaptchaException();
        }


        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();


        LoginInfo loginInfo;
        try {
            JsonResponse<LoginInfo> jsonResponse = userService.execute(new JsonRequest("queryLoginInfo", new HashMap<String, Object>() {{
                put("dlzh", username);
            }}));
            loginInfo = jsonResponse.getData();
        } catch (Exception e) {
            throw new UnknownAccountException();
        }


        if (loginInfo == null) {//用户是否存在
            throw new UnknownAccountException();
        } else if (StringUtils.isEmpty(loginInfo.getYhId()) || StringUtils.isEmpty(loginInfo.getXm()) || StringUtils.isEmpty(loginInfo.getBmzbId())) {
            throw new IncompleteUserException();
        }

//        if (user != null && !"Y".equals(user.getYxbz())) {//账户是否激活
//            throw new DisabledAccountException();
//        }
//        if (user != null && !"Y".equals(user.getYxbz())) {//账户是否锁定
//            throw new LockedAccountException();
//        }
//        ByteSource salt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginInfo, loginInfo.getMm(), getName());
        return authenticationInfo;
    }


}
