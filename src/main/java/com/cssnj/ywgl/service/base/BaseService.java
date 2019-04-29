package com.cssnj.ywgl.service.base;


import com.cssnj.ywgl.domain.common.QueryDao;
import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.dto.user.LoginInfo;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.facade.IService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;


/**
 * Created by yangxi on 2017/8/7.
 */
public abstract class BaseService implements IService {

    @Autowired
    protected QueryDao queryDaoImpl;

    protected LoginInfo loginInfo;


    protected abstract JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException;

    @Override
    public JsonResponse execute(JsonRequest jsonRequest) throws SQLException, BaseException {
        this.loginInfo = (LoginInfo) SecurityUtils.getSubject().getPrincipal();
        return invokingService(jsonRequest);
    }

}
