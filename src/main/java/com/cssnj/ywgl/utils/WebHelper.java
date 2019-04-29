package com.cssnj.ywgl.utils;


import com.cssnj.ywgl.config.SystemConfig;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DQ on 2017/1/1.
 */
public class WebHelper {


    /**
     * 添加会话属性
     *
     * @param request
     * @param attributeName
     * @param attribute
     */
    public static void addSessionAttribute(HttpServletRequest request, String attributeName, Object attribute) {
        addSessionAttribute(request, attributeName, attribute, true);

    }

    public static void addSessionAttribute(HttpServletRequest request, String attributeName, Object attribute, boolean create) {
        request.getSession(create).setAttribute(attributeName, attribute);

    }

    /**
     * 移除会话属性
     *
     * @param request
     * @param sessionId
     */
    public static void removeSessionAttribute(HttpServletRequest request, String sessionId) {
        request.getSession().removeAttribute(sessionId);
    }

    /**
     * 获取会话中指定名称属性
     *
     * @param request
     * @param attributeName
     * @return
     */
    public static String getSessionAttributeString(HttpServletRequest request, String attributeName) {
        return (String) request.getSession().getAttribute(attributeName);
    }

    /**
     * 获取会话中指定名称属性
     *
     * @param request
     * @param attributeName
     * @param <T>
     * @return
     */
    public static <T> T getSessionAttributeBean(HttpServletRequest request, String attributeName) {
        return (T) request.getSession().getAttribute(attributeName);
    }

    /**
     * 获取会话中指定名称属性
     *
     * @param request
     * @param attributeName
     * @return
     */
    public static Object getSessionAttribute(HttpServletRequest request, String attributeName) {
        return request.getSession().getAttribute(attributeName);
    }

    /**
     * 销毁会话
     *
     * @param request
     */
    public static void invalidateSession(HttpServletRequest request) {
        request.getSession().invalidate();
    }


    /**
     * 判斷客戶端是否是移动设备
     *
     * @return
     */
    public static boolean isMobile(HttpServletRequest request) {
        boolean isMoblie = false;
        String[] mobileAgents = {"aliapp", "ucbrowser", "iphone", "android", "phone", "mobile", "wap", "netfront", "java", "opera mobi",
                "opera mini", "ucweb", "windows ce", "symbian", "series", "webos", "sony", "blackberry", "dopod",
                "nokia", "samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", "motorola", "foma",
                "docomo", "up.browser", "up.link", "blazer", "helio", "hosin", "huawei", "novarra", "coolpad", "webos",
                "techfaith", "palmsource", "alcatel", "amoi", "ktouch", "nexian", "ericsson", "philips", "sagem",
                "wellcom", "bunjalloo", "maui", "smartphone", "iemobile", "spice", "bird", "zte-", "longcos",
                "pantech", "gionee", "portalmmm", "jig browser", "hiptop", "benq", "haier", "^lct", "320x320",
                "240x320", "176x220", "w3c ", "acs-", "alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac",
                "blaz", "brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", "ipaq", "java", "jigs",
                "kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", "lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi",
                "mot-", "moto", "mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", "play", "port",
                "prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", "send", "seri", "sgh-", "shar", "sie-", "siem",
                "smal", "smar", "sony", "sph-", "symb", "t-mo", "teli", "tim-", /*"tosh",*/ "tsm-", "upg1", "upsi", "vk-v",
                "voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", "winw", "xda", "xda-",
                "Googlebot-Mobile"};
        if (request.getHeader("User-Agent") != null) {
            for (String mobileAgent : mobileAgents) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
                    isMoblie = true;
                    break;
                }
            }
        }
        return isMoblie;
    }

    /**
     * 判断请求类型是否是Ajax
     *
     * @param request
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest request) {

        if (request.getHeader("x-requested-with") != null
                && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))) {
            return true;
        }
        return false;
    }

    /**
     * 设置cookie
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期  以秒为单位
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    public static void addMainCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain("/");
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }

    /**
     * 删除cookie
     *
     * @param request
     * @param response
     * @param name
     */
    public static void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie cookie = getCookieByName(request, name);
        if (cookie != null && name.equals(cookie.getName())) {
            cookie.setValue(null);
            cookie.setMaxAge(0);// 立即销毁cookie
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    public static void removeMainCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        Cookie cookie = getCookieByName(request, name);
        if (cookie != null && name.equals(cookie.getName())) {
            cookie.setDomain("/");
            cookie.setValue(null);
            cookie.setMaxAge(0);// 立即销毁cookie
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }

    /**
     * 根据名称获取cookie
     *
     * @param request
     * @param name
     * @return
     */
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 将cookie封装到Map里面
     *
     * @param request
     * @return
     */
    private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }


    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String buildQueryStringFromRequest(HttpServletRequest request) {
        String paramsStr = "";
        try {
            Enumeration enumeration = request.getParameterNames();
            while (enumeration.hasMoreElements()) {
                String paramName = (String) enumeration.nextElement();
                String[] values = request.getParameterValues(paramName);
                for (int i = 0; i < values.length; i++) {
                    paramsStr += paramName + "=" + values[i] + "&";
                }
            }
            if (!StringUtils.isEmpty(paramsStr)) {
                paramsStr = paramsStr.substring(0, paramsStr.length() - 1);
            }
        } catch (Exception e) {
        }
        return paramsStr;
    }


    public static void printJson(HttpServletResponse response, Object obj) {
        try {
            SystemConfig systemConfig = SpringContextUtil.getBean("systemConfig");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(systemConfig.ObjectMapper().writeValueAsString(obj));
            response.getWriter().flush();
        } catch (IOException e) {
        }

    }

}

