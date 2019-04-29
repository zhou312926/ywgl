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

@Controller
@RequestMapping(value = "/xtgl/tzgggl")
public class TzggglController extends BaseController {

    @Autowired
    IService tzggglService;

    private static final String PERMIT_VIEW = "tzgggl:view";
    private static final String PERMIT_ADD = "tzgggl:add";
    private static final String PERMIT_QUERY = "tzgggl:query";
    private static final String PERMIT_EDIT = "tzgggl:edit";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("saveTzgg".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, tzggglService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("xtgl/tzgggl/list");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadList",}, method = RequestMethod.POST)
    public JsonResponse loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadList");
        jsonRequest.getData().put("bt", request.getParameter("bt"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, tzggglService, PERMIT_QUERY);
    }

    @RequestMapping(value = {"/tzgg",}, method = RequestMethod.GET)
    public ModelAndView tzgg(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermission(PERMIT_EDIT);
        ModelAndView modelAndView = new ModelAndView("xtgl/tzgggl/tzgg");
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getTzgg");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = tzggglService.execute(jsonRequest);
        modelAndView.getModel().put("notice", jsonResponse.getData().get("notice"));
        return modelAndView;
    }
}
