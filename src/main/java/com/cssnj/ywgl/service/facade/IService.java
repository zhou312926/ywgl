package com.cssnj.ywgl.service.facade;


import com.cssnj.ywgl.dto.common.JsonRequest;
import com.cssnj.ywgl.dto.common.JsonResponse;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yangxi on 2017/8/7.
 */
public interface IService {

    @Transactional
    JsonResponse execute(JsonRequest jsonRequest) throws Exception;
}
