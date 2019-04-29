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
 * @Date: 2019/3/22 16:02
 */
@Controller
@RequestMapping(value = "/xtgl/gngl")
public class GnglController extends BaseController {

    @Autowired
    private IService gnglService;

    private static final String PERMIT_VIEW = "gngl:view";
    private static final String PERMIT_ADD = "gngl:add";
    private static final String PERMIT_QUERY = "gngl:query";
    private static final String PERMIT_EDIT = "gngl:edit";
    private static final String PERMIT_DEL = "gngl:del";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        if ("loadList".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_QUERY);
        } else if ("loadGncds".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("saveGncd".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("delGncd".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_DEL);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, gnglService, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("xtgl/gngl/list");
        return modelAndView;
    }

    @RequestMapping(value = {"/gncdxx",}, method = RequestMethod.GET)
    public ModelAndView gncdxx(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        checkPermission(PERMIT_EDIT);
        ModelAndView modelAndView = new ModelAndView("xtgl/gngl/gncdxx");
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getGncd");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = gnglService.execute(jsonRequest);
        modelAndView.getModel().put("gncd", jsonResponse.getData().get("gncd"));
        return modelAndView;
    }
}
