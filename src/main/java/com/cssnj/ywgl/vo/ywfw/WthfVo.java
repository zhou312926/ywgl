package com.cssnj.ywgl.vo.ywfw;

import java.io.Serializable;

/**
 * @Auther: duq
 * @Date: 2019/4/1 09:35
 */
public class WthfVo implements Serializable {

    private static final long serialVersionUID = -8087356721787611003L;
    private String id;
    private String nr;
    private String wtxxId;
    private String sfcn;
    private String bmzbId;
    private String lrsj;
    private String xgsj;
    private String lrryId;
    private String lrryXm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getWtxxId() {
        return wtxxId;
    }

    public void setWtxxId(String wtxxId) {
        this.wtxxId = wtxxId;
    }

    public String getSfcn() {
        return sfcn;
    }

    public void setSfcn(String sfcn) {
        this.sfcn = sfcn;
    }

    public String getBmzbId() {
        return bmzbId;
    }

    public void setBmzbId(String bmzbId) {
        this.bmzbId = bmzbId;
    }

    public String getLrsj() {
        return lrsj;
    }

    public void setLrsj(String lrsj) {
        this.lrsj = lrsj;
    }

    public String getXgsj() {
        return xgsj;
    }

    public void setXgsj(String xgsj) {
        this.xgsj = xgsj;
    }

    public String getLrryId() {
        return lrryId;
    }

    public void setLrryId(String lrryId) {
        this.lrryId = lrryId;
    }

    public String getLrryXm() {
        return lrryXm;
    }

    public void setLrryXm(String lrryXm) {
        this.lrryXm = lrryXm;
    }
}
