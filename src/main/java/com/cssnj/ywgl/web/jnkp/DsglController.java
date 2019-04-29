package com.cssnj.ywgl.web.jnkp;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.web.base.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * @Date: 2019-04-24 22:45
 */
@Controller
@RequestMapping(value = "/jnkp/dsgl")
public class DsglController extends BaseController {

    @Autowired
    IService dsglService;

    private static final String PERMIT_VIEW = "dsgl:view";
    private static final String PERMIT_ADD = "dsgl:add";
    private static final String PERMIT_QUERY = "dsgl:query";
    private static final String PERMIT_EDIT = "dsgl:edit";
    private static final String PERMIT_DEL = "dsgl:del";
    private static final String PERMIT_FPXS = "dsgl:fpxs";
    private static final String PERMIT_JCGX = "dsgl:jcgx";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("loadBmzbs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_VIEW);
            list.add(PERMIT_QUERY);
        } else if ("saveDsxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("updateDsxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("saveDsxs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_FPXS);
        } else if ("delDsxs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_JCGX);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, dsglService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("jnkp/dsgl/list");
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
        return execute(jsonRequest, request, response, dsglService, PERMIT_QUERY);
    }

    @RequestMapping(value = {"/ds_add",}, method = RequestMethod.GET)
    public ModelAndView ds_add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_ADD);
        ModelAndView modelAndView = new ModelAndView("jnkp/dsgl/ds_add");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadYhxxs",}, method = RequestMethod.POST)
    public JsonResponse loadYhxxs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadYhxxs");
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("bmzbId", request.getParameter("bmzbId"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, dsglService, PERMIT_EDIT);
    }


    @RequestMapping(value = {"/ds_xs",}, method = RequestMethod.GET)
    public ModelAndView js_yh(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_FPXS);
        ModelAndView modelAndView = new ModelAndView("jnkp/dsgl/ds_xs");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getDsxx");
        jsonRequest.getData().put("id", id);
        JsonResponse<Map> jsonResponse = dsglService.execute(jsonRequest);
        modelAndView.getModel().put("dsxx", jsonResponse.getData().get("dsxx"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadYfpYhxxs",}, method = RequestMethod.POST)
    public JsonResponse loadYfpYhxxs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadYfpYhxxs");
        jsonRequest.getData().put("id", request.getParameter("id"));
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("bmzbId", request.getParameter("bmzbId"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, dsglService, PERMIT_EDIT);
    }

    @RequestMapping(value = {"/ds_xs_add",}, method = RequestMethod.GET)
    public ModelAndView ds_xs_add(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_FPXS);
        ModelAndView modelAndView = new ModelAndView("jnkp/dsgl/ds_xs_add");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getDsxx");
        jsonRequest.getData().put("id", id);
        JsonResponse<Map> jsonResponse = dsglService.execute(jsonRequest);
        modelAndView.getModel().put("dsxx", jsonResponse.getData().get("dsxx"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadWfpYhxxs",}, method = RequestMethod.POST)
    public JsonResponse loadWfpYhxxs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadWfpYhxxs");
        jsonRequest.getData().put("id", request.getParameter("id"));
        jsonRequest.getData().put("dsYhId", request.getParameter("dsYhId"));
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("bmzbId", request.getParameter("bmzbId"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, dsglService, PERMIT_EDIT);
    }

}
