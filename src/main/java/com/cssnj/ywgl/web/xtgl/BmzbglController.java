package com.cssnj.ywgl.web.xtgl;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.web.base.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 * @Date: 2019/3/27 11:01
 */
@Controller
@RequestMapping(value = "/xtgl/bmzbgl")
public class BmzbglController extends BaseController {

    @Autowired
    IService bmzbglService;

    private static final String PERMIT_VIEW = "bmzbgl:view";
    private static final String PERMIT_ADD = "bmzbgl:add";
    private static final String PERMIT_QUERY = "bmzbgl:query";
    private static final String PERMIT_EDIT = "bmzbgl:edit";
    private static final String PERMIT_DEL = "bmzbgl:del";
    private static final String PERMIT_RYGL = "bmzbgl:rygl";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("loadList".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_QUERY);
        } else if ("loadBmzbxxs".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("saveBmzbxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("delBmzbxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_DEL);
        } else if ("delBmzbyh".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_RYGL);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, bmzbglService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("xtgl/bmzbgl/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/bmzbxx",}, method = RequestMethod.GET)
    public ModelAndView bmzbxx(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermission(PERMIT_EDIT);
        ModelAndView modelAndView = new ModelAndView("xtgl/bmzbgl/bmzbxx");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getBmzbxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = bmzbglService.execute(jsonRequest);
        modelAndView.getModel().put("bmzbxx", jsonResponse.getData().get("bmzbxx"));
        return modelAndView;
    }

    @RequestMapping(value = {"/bmzb_yh",}, method = RequestMethod.GET)
    public ModelAndView bmzb_yh(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermissions(PERMIT_RYGL);
        ModelAndView modelAndView = new ModelAndView("xtgl/bmzbgl/bmzb_yh");
        JsonRequest<Map> jsonRequest = new JsonRequest<>();
        jsonRequest.setHandle("getBmzbxx");
        jsonRequest.getData().put("id", id);
        JsonResponse<Map> jsonResponse = bmzbglService.execute(jsonRequest);
        modelAndView.getModel().put("bmzbxx", jsonResponse.getData().get("bmzbxx"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadYhxxs",}, method = RequestMethod.POST)
    public JsonResponse loadYhxxs(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadYhxxs");
        jsonRequest.getData().put("id", request.getParameter("id"));
        jsonRequest.getData().put("xm", request.getParameter("xm"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, bmzbglService, PERMIT_RYGL);
    }
}
