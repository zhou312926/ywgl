package com.cssnj.ywgl.dto.common;

/**
 * Created by yangxi on 2017/8/5.
 */
public class JsonResponse<T> extends DataResponse<T> {

    protected String code = "0";
    protected String msg = "";

    public JsonResponse() {
    }

    public JsonResponse(String msg) {
        this.msg = msg;
    }

    public JsonResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public JsonResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
