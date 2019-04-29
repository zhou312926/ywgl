package com.cssnj.ywgl.dto.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Auther: duq
 * @Date: 2019/3/27 12:21
 */
public class DataRequest<T> implements Serializable {
    private static final long serialVersionUID = 4861760632716850088L;

    protected T data;

    public DataRequest() {
    }

    public DataRequest(T data) {
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
