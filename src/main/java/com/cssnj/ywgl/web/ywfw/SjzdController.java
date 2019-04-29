package com.cssnj.ywgl.web.ywfw;

import com.cssnj.ywgl.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: duq
 * @Date: 2019/4/1 11:03
 */
@Controller
@RequestMapping(value = "/ywfw/sjzd")
public class SjzdController extends BaseController {

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("error/error");
        modelAndView.addObject("code", "E9000");
        modelAndView.addObject("msg", "建设中，敬请期待...");
        return modelAndView;
    }

}
