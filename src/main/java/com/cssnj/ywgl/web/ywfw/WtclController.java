package com.cssnj.ywgl.web.ywfw;

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
 * @Date: 2019/2/14 10:42
 */
@Controller
@RequestMapping(value = "/ywfw/wtcl")
public class WtclController extends BaseController {

    @Autowired
    private IService wtclService;
    @Autowired
    private IService ywDmService;

    private static final String PERMIT_VIEW = "wtcl:view";
    private static final String PERMIT_QUERY = "wtcl:query";
    private static final String PERMIT_REPLY = "wtcl:reply";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        IService service = wtclService;
        if ("queryYwmkDm".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_VIEW);
            list.add(PERMIT_QUERY);
            service = ywDmService;
        } else if ("saveReply".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_REPLY);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, service, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("ywfw/wtcl/list");
        modelAndView.getModel().put("wtlxList", ywDmService.execute(new JsonRequest("queryWtlxDm")).getData());
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = {"/loadList",}, method = RequestMethod.POST)
    public JsonResponse loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadList");
        jsonRequest.getData().put("bt", request.getParameter("bt"));
        jsonRequest.getData().put("wtlxDm", request.getParameter("wtlxDm"));
        jsonRequest.getData().put("yyxtDm", request.getParameter("yyxtDm"));
        jsonRequest.getData().put("ywmkDm", request.getParameter("ywmkDm"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, wtclService, PERMIT_QUERY);
    }


    @RequestMapping(value = {"/wtxx_read",}, method = RequestMethod.GET)
    public ModelAndView wtxx_read(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermission(PERMIT_REPLY);
        ModelAndView modelAndView = new ModelAndView("ywfw/wtcl/wtxx_read");
        modelAndView.getModel().put("wtlxList", ywDmService.execute(new JsonRequest("queryWtlxDm")).getData());
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        modelAndView.getModel().put("wtztList", ywDmService.execute(new JsonRequest("queryWtztDm")).getData());
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getWtxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = wtclService.execute(jsonRequest);
        modelAndView.getModel().put("wtxx", jsonResponse.getData().get("wtxx"));
        modelAndView.getModel().put("wthfList", jsonResponse.getData().get("wthfList"));
        return modelAndView;
    }
}
