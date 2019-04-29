package com.cssnj.ywgl.web.advice;

import com.cssnj.ywgl.config.SystemConfig;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseBizException;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.utils.WebHelper;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: duq
 * @Date: 2019/2/13 12:24
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @Autowired
    SystemConfig systemConfig;
    private JsonResponse jsonResponse;
    private ModelAndView modelAndView;

    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({SQLException.class})
    public ModelAndView sqlExceptionHandler(SQLException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("SQL异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9034");
            jsonResponse.setMsg("SQL异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9034");
            modelAndView.addObject("msg", "SQL异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView runtimeExceptionHandler(RuntimeException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("运行时异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9001");
            jsonResponse.setMsg("运行时异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9001");
            modelAndView.addObject("msg", "运行时异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({NullPointerException.class})
    public ModelAndView nullPointerExceptionHandler(NullPointerException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("空指针异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9002");
            jsonResponse.setMsg("空指针异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9002");
            modelAndView.addObject("msg", "空指针异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({ClassCastException.class})
    public ModelAndView classCastExceptionHandler(ClassCastException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("类型转换异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9003");
            jsonResponse.setMsg("类型转换异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9003");
            modelAndView.addObject("msg", "类型转换异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({IOException.class})
    public ModelAndView iOExceptionHandler(IOException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("IO异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9004");
            jsonResponse.setMsg("IO异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9004");
            modelAndView.addObject("msg", "IO异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({NoSuchMethodException.class})
    public ModelAndView noSuchMethodExceptionHandler(NoSuchMethodException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("未知方法异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9005");
            jsonResponse.setMsg("未知方法异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9005");
            modelAndView.addObject("msg", "未知方法异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({IndexOutOfBoundsException.class})
    public ModelAndView indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("数组越界异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9006");
            jsonResponse.setMsg("数组越界异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9006");
            modelAndView.addObject("msg", "数组越界异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ModelAndView requestNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("无法正确读取数据", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9007");
            jsonResponse.setMsg("无法正确读取数据");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9007");
            modelAndView.addObject("msg", "无法正确读取数据");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({TypeMismatchException.class})
    public ModelAndView requestTypeMismatch(TypeMismatchException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("类型不匹配异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9008");
            jsonResponse.setMsg("类型不匹配异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9008");
            modelAndView.addObject("msg", "类型不匹配异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ModelAndView requestMissingServletRequest(MissingServletRequestParameterException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("缺失请求参数异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9009");
            jsonResponse.setMsg("缺失请求参数异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9009");
            modelAndView.addObject("msg", "缺失请求参数异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView request405(HttpRequestMethodNotSupportedException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("请求方法不支持异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9010");
            jsonResponse.setMsg("请求方法不支持异常");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9010");
            modelAndView.addObject("msg", "请求方法不支持异常");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ModelAndView request406(HttpMediaTypeNotAcceptableException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("返回的数据类型不支持", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9011");
            jsonResponse.setMsg("返回的数据类型不支持");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9011");
            modelAndView.addObject("msg", "返回的数据类型不支持");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({ConversionNotSupportedException.class})
    public ModelAndView server500(ConversionNotSupportedException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("没有为bean属性找到合适的编辑器或转换器", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9012");
            jsonResponse.setMsg("没有为bean属性找到合适的编辑器或转换器");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9012");
            modelAndView.addObject("msg", "没有为bean属性找到合适的编辑器或转换器");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }

    @ExceptionHandler({HttpMessageNotWritableException.class})
    public ModelAndView server500(HttpMessageNotWritableException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("数据无法正确返回", ex);

        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9013");
            jsonResponse.setMsg("数据无法正确返回");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9013");
            modelAndView.addObject("msg", "数据无法正确返回");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }


    @ExceptionHandler({BaseException.class})
    private ModelAndView baseException(BaseException ex, HttpServletRequest request, HttpServletResponse response) {
        String var4;
        if (null != ex.getErrorCode() && !"".equals(ex.getErrorCode())) {
            var4 = ex.getErrorCode();
        } else if (ex instanceof BaseBizException) {
            var4 = "E9014";
        } else {
            var4 = "E9015";
        }

        String var5;
        if (null != ex.getMessage() && !"".equals(ex.getMessage())) {
            logger.error("不明异常", ex);
            var5 = ex.getMessage();
        } else if (ex instanceof BaseBizException) {
            logger.error("业务逻辑异常", ex);
            var5 = ex.getMessage();
        } else {
            logger.error("系统级异常", ex);
            var5 = "系统级异常";
        }

        jsonResponse = new JsonResponse();
        jsonResponse.setCode(var4);
        jsonResponse.setMsg(var5);
        if (WebHelper.isAjaxRequest(request)) {
            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", jsonResponse.getCode());
            modelAndView.addObject("msg", jsonResponse.getMsg());
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }


    @ExceptionHandler({UnauthorizedException.class})
    public ModelAndView unauthorizedException(RuntimeException ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error("未经授权异常", ex);
        if (WebHelper.isAjaxRequest(request)) {
            jsonResponse = new JsonResponse();
            jsonResponse.setCode("E9015");
            jsonResponse.setMsg("权限不足");

            WebHelper.printJson(response, jsonResponse);
            return null;
        } else {
            modelAndView = new ModelAndView();
            modelAndView.addObject("code", "E9015");
            modelAndView.addObject("msg", "权限不足");
            modelAndView.addObject("repData", ex.getMessage());
            modelAndView.setViewName("error/error");
            return modelAndView;
        }
    }
}
