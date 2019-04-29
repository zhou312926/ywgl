package com.cssnj.ywgl.web.cxtj;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.utils.DateUtil;
import com.cssnj.ywgl.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/4/10 16:23
 */
@Controller
@RequestMapping(value = "/cxtj/ywwthz")
public class YwwthzController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(YwwthzController.class);

    @Autowired
    private IService ywwthzService;

    private static final String PERMIT_VIEW = "ywwthz:view";
    private static final String PERMIT_QUERY = "ywwthz:query";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return execute(jsonRequest, request, response, ywwthzService);
    }

    @RequestMapping(value = {"/hzlist",}, method = RequestMethod.GET)
    public ModelAndView hzlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("cxtj/ywwthz/hzlist");
        String nowStr = DateUtil.getNowString("yyyy-MM-dd");
        modelAndView.getModel().put("hzrqq", nowStr);
        modelAndView.getModel().put("hzrqz", nowStr);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadHzList",}, method = RequestMethod.POST)
    public JsonResponse loadHzList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadHzList");
        jsonRequest.getData().put("hzlx", request.getParameter("hzlx"));
        jsonRequest.getData().put("hzrqq", request.getParameter("hzrqq"));
        jsonRequest.getData().put("hzrqz", request.getParameter("hzrqz"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, ywwthzService, PERMIT_QUERY);
    }

    @RequestMapping(value = {"/mxlist",}, method = RequestMethod.GET)
    public ModelAndView mxlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("cxtj/ywwthz/mxlist");
        modelAndView.getModel().put("hzlx", request.getParameter("hzlx"));
        modelAndView.getModel().put("hzid", request.getParameter("hzid"));
        modelAndView.getModel().put("hzrqq", request.getParameter("hzrqq"));
        modelAndView.getModel().put("hzrqz", request.getParameter("hzrqz"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadMxList",}, method = RequestMethod.POST)
    public JsonResponse loadMxList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadMxList");
        jsonRequest.getData().put("hzlx", request.getParameter("hzlx"));
        jsonRequest.getData().put("hzid", request.getParameter("hzid"));
        jsonRequest.getData().put("hzrqq", request.getParameter("hzrqq"));
        jsonRequest.getData().put("hzrqz", request.getParameter("hzrqz"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, ywwthzService, PERMIT_QUERY);
    }

}
