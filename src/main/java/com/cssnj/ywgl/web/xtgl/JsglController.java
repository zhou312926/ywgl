package com.cssnj.ywgl.web.xtgl;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.web.base.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/22 09:23
 */
@Controller
@RequestMapping(value = "/xtgl/jsgl")
public class JsglController extends BaseController {

    @Autowired
    IService jsglService;

    private static final String PERMIT_VIEW = "jsgl:view";
    private static final String PERMIT_ADD = "jsgl:add";
    private static final String PERMIT_QUERY = "jsgl:query";
    private static final String PERMIT_EDIT = "jsgl:edit";
    private static final String PERMIT_DEL = "jsgl:del";
    private static final String PERMIT_FPGNCD = "jsgl:fpgncd";
    private static final String PERMIT_SQYH = "jsgl:sqyh";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("loadList".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_QUERY);
        } else if ("loadJsxxs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("saveJsxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("delJsxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_DEL);
        } else if ("loadGncds".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_FPGNCD);
        } else if ("saveJsgncd".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_FPGNCD);
        } else if ("saveJsyh".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_SQYH);
        } else if ("delJsyh".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_SQYH);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, jsglService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("xtgl/jsgl/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/jsxx",}, method = RequestMethod.GET)
    public ModelAndView jsxx(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermission(PERMIT_EDIT);
        ModelAndView modelAndView = new ModelAndView("xtgl/jsgl/jsxx");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getJsxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = jsglService.execute(jsonRequest);
        modelAndView.getModel().put("jsxx", jsonResponse.getData().get("jsxx"));
        return modelAndView;
    }

    @RequestMapping(value = {"/js_gncd",}, method = RequestMethod.GET)
    public ModelAndView js_gncd(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_FPGNCD);
        ModelAndView modelAndView = new ModelAndView("xtgl/jsgl/js_gncd");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getJsxx");
        jsonRequest.getData().put("id", id);
        JsonResponse<Map> jsonResponse = jsglService.execute(jsonRequest);
        modelAndView.getModel().put("jsxx", jsonResponse.getData().get("jsxx"));
        return modelAndView;
    }

    @RequestMapping(value = {"/js_yh",}, method = RequestMethod.GET)
    public ModelAndView js_yh(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_SQYH);
        ModelAndView modelAndView = new ModelAndView("xtgl/jsgl/js_yh");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getJsxx");
        jsonRequest.getData().put("id", id);
        JsonResponse<Map> jsonResponse = jsglService.execute(jsonRequest);
        modelAndView.getModel().put("jsxx", jsonResponse.getData().get("jsxx"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadYsqYhxxs",}, method = RequestMethod.POST)
    public JsonResponse loadYsqYhxxs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadYsqYhxxs");
        jsonRequest.getData().put("id", request.getParameter("id"));
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("bmzbId", request.getParameter("bmzbId"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, jsglService, PERMIT_SQYH);
    }

    @RequestMapping(value = {"/js_yh_add",}, method = RequestMethod.GET)
    public ModelAndView js_yh_add(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_SQYH);
        ModelAndView modelAndView = new ModelAndView("xtgl/jsgl/js_yh_add");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getJsxx");
        jsonRequest.getData().put("id", id);
        JsonResponse<Map> jsonResponse = jsglService.execute(jsonRequest);
        modelAndView.getModel().put("jsxx", jsonResponse.getData().get("jsxx"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadWsqYhxxs",}, method = RequestMethod.POST)
    public JsonResponse loadWsqYhxxs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadWsqYhxxs");
        jsonRequest.getData().put("id", request.getParameter("id"));
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("bmzbId", request.getParameter("bmzbId"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, jsglService, PERMIT_SQYH);
    }
}
