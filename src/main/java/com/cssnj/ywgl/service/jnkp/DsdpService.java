package com.cssnj.ywgl.service.jnkp;

import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import com.cssnj.ywgl.exception.BaseException;
import com.cssnj.ywgl.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @Auther: duq
 * @Date: 2019-04-27 10:27
 */
@Service
public class DsdpService extends BaseService {
    @Override
    protected JsonResponse invokingService(JsonRequest jsonRequest) throws SQLException, BaseException {
        return null;
    }
}
