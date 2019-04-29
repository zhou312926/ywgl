package com.cssnj.ywgl.web.home;

import com.cssnj.ywgl.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: duq
 * @Date: 2019/1/29 15:53
 */
@Controller
@RequestMapping(value = "/home")
public class HomeConsole extends BaseController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String toConsole(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "home/console";
    }

}
