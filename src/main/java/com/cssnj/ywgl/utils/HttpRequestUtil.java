package com.cssnj.ywgl.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/25 09:16
 */
public class HttpRequestUtil {


    /**
     * 将request中的参数并转为Map
     *
     * @param request
     * @return
     */
    public static Map<String, Object> getParamFromRequest(HttpServletRequest request) {
        Enumeration pNames = request.getParameterNames();
        Map<String, Object> backMap = new HashMap<>();
        String name;
        String value;
        while (pNames.hasMoreElements()) {
            name = (String) pNames.nextElement();
            value = request.getParameter(name);
            backMap.put(name, value);
        }
        return backMap;
    }
}
