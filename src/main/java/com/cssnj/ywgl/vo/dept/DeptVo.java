package com.cssnj.ywgl.vo.dept;

import java.io.Serializable;

/**
 * @Auther: duq
 * @Date: 2019/3/27 16:15
 */
public class DeptVo implements Serializable {

    private static final long serialVersionUID = 7618217249643987481L;
    private String id;

    private String mc;

    private String ms;

    private Integer xh;

    private String sjbmzbId;

    private String yxbz;

    private String open;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getSjbmzbId() {
        return sjbmzbId;
    }

    public void setSjbmzbId(String sjbmzbId) {
        this.sjbmzbId = sjbmzbId;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
