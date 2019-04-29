package com.cssnj.ywgl.web.ywfw;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.web.base.BaseController;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/4/1 11:19
 */
@Controller
@RequestMapping(value = "/ywfw/ywjb")
public class YwjbController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(YwjbController.class);

    @Autowired
    private IService ywjbService;
    @Autowired
    private IService ywDmService;

    private static final String PERMIT_VIEW = "ywjb:view";
    private static final String PERMIT_ADD = "ywjb:add";
    private static final String PERMIT_QUERY = "ywjb:query";
    private static final String PERMIT_EDIT = "ywjb:edit";
    private static final String PERMIT_DEL = "ywjb:del";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("saveYwjb".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("delYwjb".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_DEL);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, ywjbService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("ywfw/ywjb/list");
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/loadList",}, method = RequestMethod.POST)
    public JsonResponse loadList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadList");
        jsonRequest.getData().put("bt", request.getParameter("bt"));
        jsonRequest.getData().put("yyxtDm", request.getParameter("yyxtDm"));
        jsonRequest.getData().put("page", request.getParameter("page"));
        jsonRequest.getData().put("limit", request.getParameter("limit"));
        return execute(jsonRequest, request, response, ywjbService, PERMIT_QUERY);
    }

    @RequestMapping(value = {"/ywjb_read",}, method = RequestMethod.GET)
    public ModelAndView ywjb_read(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("ywfw/ywjb/ywjb_read");
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getYwjb");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = execute(jsonRequest, request, response, ywjbService, PERMIT_QUERY);
        modelAndView.getModel().put("ywjb", jsonResponse.getData().get("ywjb"));
        return modelAndView;
    }

    @RequestMapping(value = {"/ywjb",}, method = RequestMethod.GET)
    public ModelAndView ywjb(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("ywfw/ywjb/ywjb");
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getYwjb");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = execute(jsonRequest, request, response, ywjbService, PERMIT_EDIT);
        modelAndView.getModel().put("ywjb", jsonResponse.getData().get("ywjb"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/upload/template/ywjb", method = RequestMethod.POST)
    public JsonResponse uploadWtxx(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = true) MultipartFile file) throws Exception {
        JsonRequest<MultipartFile> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("uploadYwjb");
        jsonRequest.setData(file);
        return execute(jsonRequest, request, response, ywjbService, PERMIT_EDIT);
    }
}
