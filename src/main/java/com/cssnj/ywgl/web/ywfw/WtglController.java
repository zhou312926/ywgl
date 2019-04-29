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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/2/14 10:42
 */
@Controller
@RequestMapping(value = "/ywfw/wtgl")
public class WtglController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(WtglController.class);

    @Autowired
    private IService wtglService;
    @Autowired
    private IService ywDmService;

    private static final String PERMIT_VIEW = "wtgl:view";
    private static final String PERMIT_ADD = "wtgl:add";
    private static final String PERMIT_QUERY = "wtgl:query";
    private static final String PERMIT_EDIT = "wtgl:edit";
    private static final String PERMIT_DEL = "wtgl:del";

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public JsonResponse general(@RequestBody JsonRequest jsonRequest, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<String> list = new ArrayList<>();
        IService service = wtglService;
        if ("queryYwmkDm".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_VIEW);
            list.add(PERMIT_QUERY);
            service = ywDmService;
        } else if ("saveWtxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_EDIT);
        } else if ("delWtxx".equals(jsonRequest.getHandle())) {
            list.add(PERMIT_DEL);
        }
        String[] permits = new String[list.size()];
        return execute(jsonRequest, request, response, service, list.toArray(permits));
    }

    @RequestMapping(value = {"/list",}, method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermissions(PERMIT_VIEW, PERMIT_QUERY);
        ModelAndView modelAndView = new ModelAndView("ywfw/wtgl/list");
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
        return execute(jsonRequest, request, response, wtglService, PERMIT_QUERY);
    }


    @RequestMapping(value = {"/wtxx_read",}, method = RequestMethod.GET)
    public ModelAndView wtxx_read(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("ywfw/wtgl/wtxx_read");
        modelAndView.getModel().put("wtlxList", ywDmService.execute(new JsonRequest("queryWtlxDm")).getData());
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        modelAndView.getModel().put("wtztList", ywDmService.execute(new JsonRequest("queryWtztDm")).getData());
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getWtxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = execute(jsonRequest, request, response, wtglService, PERMIT_QUERY);
        modelAndView.getModel().put("wtxx", jsonResponse.getData().get("wtxx"));
        modelAndView.getModel().put("wthfList", jsonResponse.getData().get("wthfList"));
        return modelAndView;
    }

    @RequestMapping(value = {"/wtxx",}, method = RequestMethod.GET)
    public ModelAndView wtxx(HttpServletRequest request, HttpServletResponse response, @Param("id") String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("ywfw/wtgl/wtxx");
        modelAndView.getModel().put("wtlxList", ywDmService.execute(new JsonRequest("queryWtlxDm")).getData());
        modelAndView.getModel().put("yyxtList", ywDmService.execute(new JsonRequest("queryYyxtDm")).getData());
        modelAndView.getModel().put("wtztList", ywDmService.execute(new JsonRequest("queryWtztDm")).getData());
        JsonRequest<Map> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("getWtxx");
        jsonRequest.getData().put("id", StringUtils.isEmpty(id) ? "" : id);
        JsonResponse<Map> jsonResponse = execute(jsonRequest, request, response, wtglService, PERMIT_EDIT);
        modelAndView.getModel().put("wtxx", jsonResponse.getData().get("wtxx"));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = {"/download/template/wtxx",}, method = RequestMethod.GET)
    public String downloadWtxx(HttpServletRequest request, HttpServletResponse response) throws Exception {
        checkPermission(PERMIT_EDIT);
        String fileName = "运维问题模板.xlsx";
        String filePath = System.getProperty("user.dir");
        File file = new File(filePath + "/download/template/" + fileName);
        if (file.exists()) {
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                response.setContentType("application/octet-stream");
//                response.setHeader("content-type", "application/octet-stream");
//                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
                response.addHeader("Content-Disposition", "attachment;fileName=" + new String(fileName.getBytes("UTF-8"), "iso-8859-1"));

                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                os.flush();
                os.close();
            } catch (Exception e) {
                logger.error("运维问题模板出错", e);
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        return "下载出错";
    }

    @ResponseBody
    @RequestMapping(value = "/upload/template/wtxx", method = RequestMethod.POST)
    public JsonResponse uploadWtxx(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "file", required = true) MultipartFile file) throws Exception {
        JsonRequest<MultipartFile> jsonRequest = new JsonRequest();
        jsonRequest.setHandle("uploadWtxx");
        jsonRequest.setData(file);
        return execute(jsonRequest, request, response, wtglService, PERMIT_EDIT);
    }
}
