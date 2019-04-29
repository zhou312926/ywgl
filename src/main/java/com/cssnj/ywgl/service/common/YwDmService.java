package com.cssnj.ywgl.service.common;

import com.cssnj.ywgl.domain.ywdm.WtlxMapper;
import com.cssnj.ywgl.domain.ywdm.WtztMapper;
import com.cssnj.ywgl.domain.ywdm.YwmkMapper;
import com.cssnj.ywgl.domain.ywdm.YyxtMapper;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/3/19 11:04
 */
@Service
public class YwDmService extends BaseService {

    @Autowired
    private WtlxMapper wtlxMapper;
    @Autowired
    private YyxtMapper yyxtMapper;
    @Autowired
    private YwmkMapper ywmkMapper;
    @Autowired
    private WtztMapper wtztMapper;

    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        if ("queryWtlxDm".equals(jsonRequest.getHandle())) {
            return queryWtlxDm(jsonRequest);
        } else if ("queryYyxtDm".equals(jsonRequest.getHandle())) {
            return queryYyxtDm(jsonRequest);
        } else if ("queryYwmkDm".equals(jsonRequest.getHandle())) {
            return queryYwmkDm(jsonRequest);
        } else if ("queryWtztDm".equals(jsonRequest.getHandle())) {
            return queryWtztDm(jsonRequest);
        }
        return null;
    }


    private JsonResponse queryWtlxDm(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<List> jsonResponse = new JsonResponse<>();
        jsonResponse.setData(wtlxMapper.selectAll());
        return jsonResponse;
    }

    private JsonResponse queryYyxtDm(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<List> jsonResponse = new JsonResponse<>();
        jsonResponse.setData(yyxtMapper.selectAll());
        return jsonResponse;
    }

    private JsonResponse queryYwmkDm(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<List> jsonResponse = new JsonResponse<>();
        String yyxtDm = String.valueOf(jsonRequest.getData().get("yyxtDm"));
        jsonResponse.setData(ywmkMapper.selectAll(yyxtDm));
        return jsonResponse;
    }


    private JsonResponse queryWtztDm(JsonRequest<Map> jsonRequest) throws SQLException, BaseException {
        JsonResponse<List> jsonResponse = new JsonResponse<>();
        jsonResponse.setData(wtztMapper.selectAll());
        return jsonResponse;
    }
}
