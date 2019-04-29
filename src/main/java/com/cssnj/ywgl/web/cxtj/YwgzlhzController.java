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
@RequestMapping(value = "/cxtj/ywgzlhz")
public class YwgzlhzController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(YwgzlhzController.class);

    @Autowired
    private IService ywgzlhzService;

    private static final String PERMIT_VIEW = "ywgzlhz:view";
    private static final String PERMIT_QUERY = "ywgzlhz:query";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return execute(jsonRequest, request, response, ywgzlhzService);
    }

    @RequestMapping(value = {"/hzlist",}, method = RequestMethod.GET)
    public ModelAndView hzlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("cxtj/ywgzlhz/hzlist");
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
        jsonRequest.getData().put("hzrqq", request.getParameter("hzrqq"));
        jsonRequest.getData().put("hzrqz", request.getParameter("hzrqz"));
        jsonRequest.getData().put("gzlq", request.getParameter("gzlq"));
        jsonRequest.getData().put("gzlz", request.getParameter("gzlz"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, ywgzlhzService, PERMIT_QUERY);
    }


}
