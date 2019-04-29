package com.cssnj.ywgl.utils;

import java.util.UUID;

/**
 * @Author: DQ
 * @Date: 2018/5/28下午10:36
 */
public class ApplicationUtil {

    public static String createDBID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
