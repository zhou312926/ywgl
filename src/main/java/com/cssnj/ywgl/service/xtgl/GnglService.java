package com.cssnj.ywgl.service.xtgl;

import com.cssnj.ywgl.domain.xtzy.Resource;
import com.cssnj.ywgl.domain.xtzy.ResourceMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import com.cssnj.ywgl.utils.ApplicationUtil;
import com.cssnj.ywgl.vo.xtzy.ResourceVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/22 15:48
 */
@Service
public class GnglService extends BaseService {

    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("loadList".equals(jsonRequest.getHandle())) {
            return loadList(jsonRequest);
        } else if ("getGncd".equals(jsonRequest.getHandle())) {
            return getGncd(jsonRequest);
        } else if ("loadGncds".equals(jsonRequest.getHandle())) {
            return loadGncds(jsonRequest);
        } else if ("saveGncd".equals(jsonRequest.getHandle())) {
            return saveGncd(jsonRequest);
        } else if ("delGncd".equals(jsonRequest.getHandle())) {
            return delGncd(jsonRequest);
        }
        return null;
    }


    private JsonResponse loadList(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<ResourceVo> list = resourceMapper.selectForList(loginInfo.getYhId());
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }


    private JsonResponse getGncd(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        ResourceVo gncd;
        if (!StringUtils.isEmpty(id)) {
            Resource resource = resourceMapper.selectByPrimaryKey(id);
            gncd = new ResourceVo(resource);
        } else {
            gncd = new ResourceVo();
        }
        jsonResponse.getData().put("gncd", gncd);
        return jsonResponse;
    }


    private JsonResponse loadGncds(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        List<ResourceVo> list = resourceMapper.selectForEdit();
        jsonResponse.getData().put("list", list);
        return jsonResponse;
    }


    private JsonResponse saveGncd(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
        String id = (String) jsonRequest.getData().get("id");
        String mc = (String) jsonRequest.getData().get("mc");
        String jc = (String) jsonRequest.getData().get("jc");
        String lx = (String) jsonRequest.getData().get("lx");
        String url = (String) jsonRequest.getData().get("url");
        String qxbs = (String) jsonRequest.getData().get("qxbs");
        String dkfs = (String) jsonRequest.getData().get("dkfs");
        String icon = (String) jsonRequest.getData().get("icon");
        String xh = (String) jsonRequest.getData().get("xh");
        String sjgncdId = (String) jsonRequest.getData().get("sjgncdId");
        String yxbz = (String) jsonRequest.getData().get("yxbz");

        if (StringUtils.isEmpty(mc) || StringUtils.isEmpty(lx) || StringUtils.isEmpty(sjgncdId) || StringUtils.isEmpty(yxbz)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("非法参数");
            return jsonResponse;
        } else if ("1".equals(lx) && StringUtils.isEmpty(url)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("菜单url不能为空");
            return jsonResponse;
        } else if (!"0".equals(lx) && StringUtils.isEmpty(qxbs)) {
            jsonResponse.setCode("-1");
            jsonResponse.setMsg("菜单或功能，权限标识不能为空");
            return jsonResponse;
        }

        if ("0".equals(lx)) {
            url = "";
            qxbs = "";
            dkfs = "";
        }

        Resource resource = new Resource();
        resource.setMc(mc);
        resource.setJc(jc);
        resource.setLx(lx);
        resource.setUrl(url);
        resource.setQxbs(qxbs);
        resource.setDkfs(dkfs);
        resource.setIcon(icon);
        if (!StringUtils.isEmpty(xh)) {
            resource.setXh(Integer.parseInt(xh));
        }
        resource.setSjgncdId(sjgncdId);
        resource.setYxbz(yxbz);

        if (StringUtils.isEmpty(id)) {
            resource.setId(ApplicationUtil.createDBID());
            resourceMapper.insert(resource);
        } else {
            resource.setId(id);
            resourceMapper.updateByPrimaryKeySelective(resource);
        }
        return jsonResponse;
    }


    private JsonResponse delGncd(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<Map> jsonResponse = new JsonResponse<>();
//        String id = (String) jsonRequest.getData().get("id");
//        if (!StringUtils.isEmpty(id)) {
//            resourceMapper.deleteByPrimaryKey(id);
//        }
        return jsonResponse;
    }

}
