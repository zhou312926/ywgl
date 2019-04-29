package com.cssnj.ywgl.vo.common;

import java.io.Serializable;

/**
 * @Auther: duq
 * @Date: 2019/3/27 12:15
 */
public class PageInfo<T> implements Serializable{

    private static final long serialVersionUID = 4453690700644609646L;
    private Integer rows;//每页记录数
    private Integer count;//总记录数
    private Integer total;//总页数
    private Integer page;//当前页
    private T data;

    public PageInfo() {
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
