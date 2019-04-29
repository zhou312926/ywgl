package com.cssnj.ywgl.web.user;

import com.cssnj.ywgl.constant.Constants;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.dto.user.CaptchaToken;
import com.cssnj.ywgl.exception.CaptchaException;
import com.cssnj.ywgl.exception.IncompleteUserException;
import com.cssnj.ywgl.service.common.AsyncService;
import com.cssnj.ywgl.service.facade.IService;
import com.cssnj.ywgl.utils.WebHelper;
import com.cssnj.ywgl.utils.vcode.Captcha;
import com.cssnj.ywgl.utils.vcode.GifCaptcha;
import com.cssnj.ywgl.web.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/1/15 19:02
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private IService userService;
    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, HttpServletResponse response) {//@ModelAttribute("message") String message
        if (SecurityUtils.getSubject().isAuthenticated() || SecurityUtils.getSubject().isRemembered()) {
            return "redirect:/index";
        } else {
            return "user/login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                          @RequestParam(value = "password", required = false, defaultValue = "") String password,
                          @RequestParam(value = "vcode", required = false, defaultValue = "") String vcode,
                          @RequestParam(value = "rememberMe", required = false, defaultValue = "false") boolean rememberMe,
                          RedirectAttributes redirectAttributes, HttpServletRequest request) {
        AuthenticationToken authenticationToken = new CaptchaToken(username, password, vcode, rememberMe);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(authenticationToken);
            asyncService.refreshUserExtend();
        } catch (CaptchaException uae) {
            redirectAttributes.addFlashAttribute("message", "验证码错误");
        } catch (UnknownAccountException uae) {
            redirectAttributes.addFlashAttribute("message", "账户未注册");//用户不存在
        } catch (IncompleteUserException iue) {
            redirectAttributes.addFlashAttribute("message", "用户信息不完整");
        } catch (IncorrectCredentialsException ice) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");//密码不正确
        } catch (LockedAccountException lae) {
            redirectAttributes.addFlashAttribute("message", "账户已锁定");//账户已锁定
        } catch (ExcessiveAttemptsException eae) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "未知错误");
        } finally {
            if (currentUser.isAuthenticated()) {
                request.getSession().setAttribute(Constants.SESSION_AUTHENTICATED_USER, currentUser.getPrincipal());
            } else {
                redirectAttributes.addFlashAttribute("username", username);
                redirectAttributes.addFlashAttribute("vcode", vcode);
            }
            return "redirect:/user/login";
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/user/login";
    }


    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void getGifCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        Captcha captcha = new GifCaptcha(120, 40, 4);
        WebHelper.addSessionAttribute(request, "vcode", captcha.text().toLowerCase());
        captcha.out(response.getOutputStream());
    }

    @RequestMapping(value = {"/info",}, method = RequestMethod.GET)
    public ModelAndView info(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("user/userInfo");
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getUserInfo");
        JsonResponse jsonResponse = execute(jsonRequest, request, response, userService);
        modelAndView.getModel().put("userInfo", jsonResponse.getData());
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    public JsonResponse saveInfo(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return execute(jsonRequest, request, response, userService);
    }

    @RequestMapping(value = {"/pwd",}, method = RequestMethod.GET)
    public ModelAndView pwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("user/password");
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getUserInfo");
        JsonResponse jsonResponse = execute(jsonRequest, request, response, userService);
        modelAndView.getModel().put("userInfo", jsonResponse.getData());
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/savePwd", method = RequestMethod.POST)
    public JsonResponse savePwd(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return execute(jsonRequest, request, response, userService);
    }

}
