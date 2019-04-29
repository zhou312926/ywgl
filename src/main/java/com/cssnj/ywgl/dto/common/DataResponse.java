package com.cssnj.ywgl.dto.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Auther: duq
 * @Date: 2019/3/27 12:41
 */
public class DataResponse<T> implements Serializable {
    private static final long serialVersionUID = 8981357450069863023L;

    protected T data;

    public DataResponse() {
    }

    public DataResponse(T data) {
        this.data = data;
    }

    public T getData() {
        if (data == null) {
            data = (T) (new HashMap());
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
