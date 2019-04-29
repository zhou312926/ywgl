package com.cssnj.ywgl.web.base;


import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: duq
 * @Date: 2019/2/14 10:47
 */
public class BaseController {


    protected <T> JsonResponse<T> execute(JsonRequest<T> jsonRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, IService service) throws Exception {
        return execute(jsonRequest, httpServletRequest, httpServletResponse, service, new String[0]);
    }


    protected <T> JsonResponse<T> execute(JsonRequest<T> jsonRequest, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, IService service, String... permits) throws Exception {
//        IService service = SpringContextUtil.getBean(jsonRequest.getServiceName());
        if (permits != null && permits.length > 0) {
            checkPermissions(permits);
        }
//        if (jsonRequest.getData() == null) {
//            jsonRequest.setData(new HashMap());
//        }
//        jsonRequest.getData().put("httpServletRequest", httpServletRequest);
//        jsonRequest.getData().put("httpServletResponse", httpServletResponse);
        JsonResponse jsonResponse = new JsonResponse();
        if (service != null) {
            jsonResponse = service.execute(jsonRequest);
        }
        return jsonResponse;
    }


    protected void checkPermission(String permit) {
        checkPermissions(permit);
    }

    protected void checkPermissions(String... permits) {
        Subject subject = SecurityUtils.getSubject();
        subject.checkPermissions(permits);
    }

}
