package com.cssnj.ywgl.vo.user;

import java.io.Serializable;

/**
 * @Auther: duq
 * @Date: 2019/3/27 09:24
 */
public class UserVo implements Serializable {
    private static final long serialVersionUID = 8659817523450149431L;

    private String id;

    private String xm;

    private String xb;

    private String csrq;

    private String yddh;

    private String gddh;

    private String dzyx;

    private String bmzbId;

    private String bmzbMc;

    private String yxbz;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getYddh() {
        return yddh;
    }

    public void setYddh(String yddh) {
        this.yddh = yddh;
    }

    public String getGddh() {
        return gddh;
    }

    public void setGddh(String gddh) {
        this.gddh = gddh;
    }

    public String getDzyx() {
        return dzyx;
    }

    public void setDzyx(String dzyx) {
        this.dzyx = dzyx;
    }

    public String getBmzbId() {
        return bmzbId;
    }

    public void setBmzbId(String bmzbId) {
        this.bmzbId = bmzbId;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public String getBmzbMc() {
        return bmzbMc;
    }

    public void setBmzbMc(String bmzbMc) {
        this.bmzbMc = bmzbMc;
    }

}
