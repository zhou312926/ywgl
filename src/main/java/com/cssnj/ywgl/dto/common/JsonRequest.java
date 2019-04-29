package com.cssnj.ywgl.dto.common;

/**
 * Created by yangxi on 2017/8/5.
 */
public class JsonRequest<T> extends DataRequest<T> {

    protected String service;
    protected String handle;

    public JsonRequest() {
    }

    public JsonRequest(String handle) {
        this.handle = handle;
    }

    public JsonRequest(String handle, T data) {
        this.handle = handle;
        this.data = data;
    }

    public JsonRequest(String service, String handle, T data) {
        this.service = service;
        this.handle = handle;
        this.data = data;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
