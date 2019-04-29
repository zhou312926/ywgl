package com.cssnj.ywgl.web;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.web.base.BaseController;
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
 * @Date: 2019/1/4 13:08
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private IService menuService;
    @Autowired
    private IService userService;


    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public ModelAndView toIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("loadMenu");
        JsonResponse<Map> jsonResponse = execute(jsonRequest, request, response, menuService);
        modelAndView.getModel().put("menus", jsonResponse.getData().get("menus"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/getTzgg",}, method = RequestMethod.POST)
    public JsonResponse getTzgg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getTzgg");
        return execute(jsonRequest, request, response, userService);
    }

    @ResponseBody
    @RequestMapping(value = {"/saveYhTzgg",}, method = RequestMethod.POST)
    public JsonResponse saveYhTzgg(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        jsonRequest.setHandle("saveYhTzgg");
        return execute(jsonRequest, request, response, userService);
    }

}
