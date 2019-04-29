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
 * @Date: 2019/3/26 20:59
 */
@Controller
@RequestMapping(value = "/xtgl/yhgl")
public class YhglController extends BaseController {

    @Autowired
    IService yhglService;

    private static final String PERMIT_VIEW = "yhgl:view";
    private static final String PERMIT_ADD = "yhgl:add";
    private static final String PERMIT_QUERY = "yhgl:query";
    private static final String PERMIT_EDIT = "yhgl:edit";
    private static final String PERMIT_DEL = "yhgl:del";
    private static final String PERMIT_SQJS = "yhgl:sqjs";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("loadBmzbs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_VIEW);
            list.add(PERMIT_QUERY);
        } else if ("saveYhxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("delYhxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_DEL);
        } else if ("loadJsxxs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_SQJS);
        } else if ("saveYhjs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_SQJS);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, yhglService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("xtgl/yhgl/list");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadList",}, method = RequestMethod.POST)
    public JsonResponse loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadList");
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("bmzbId", request.getParameter("bmzbId"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, yhglService, PERMIT_QUERY);
    }

    @RequestMapping(value = {"/yhxx",}, method = RequestMethod.GET)
    public ModelAndView yhxx(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermission(PERMIT_EDIT);
        ModelAndView modelAndView = new ModelAndView("xtgl/yhgl/yhxx");
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getYhxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = yhglService.execute(jsonRequest);
        modelAndView.getModel().put("yhxx", jsonResponse.getData().get("yhxx"));
        return modelAndView;
    }

    @RequestMapping(value = {"/yh_js",}, method = RequestMethod.GET)
    public ModelAndView yh_js(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_SQJS);
        ModelAndView modelAndView = new ModelAndView("xtgl/yhgl/yh_js");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getYhxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = yhglService.execute(jsonRequest);
        modelAndView.getModel().put("yhxx", jsonResponse.getData().get("yhxx"));
        return modelAndView;
    }
}
