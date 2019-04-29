package com.cssnj.ywgl.domain.dept;

import java.io.Serializable;
import java.util.Date;

public class Dept implements Serializable {
    private String id;

    private String mc;

    private String ms;

    private Integer xh;

    private String sjbmzbId;

    private String yxbz;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Dept(String id, String mc, String ms, Integer xh, String sjbmzbId, String yxbz, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.mc = mc;
        this.ms = ms;
        this.xh = xh;
        this.sjbmzbId = sjbmzbId;
        this.yxbz = yxbz;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Dept() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc == null ? null : mc.trim();
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms == null ? null : ms.trim();
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
        this.sjbmzbId = sjbmzbId == null ? null : sjbmzbId.trim();
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz == null ? null : yxbz.trim();
    }

    public String getLrry() {
        return lrry;
    }

    public void setLrry(String lrry) {
        this.lrry = lrry == null ? null : lrry.trim();
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public String getXgry() {
        return xgry;
    }

    public void setXgry(String xgry) {
        this.xgry = xgry == null ? null : xgry.trim();
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Dept other = (Dept) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getMs() == null ? other.getMs() == null : this.getMs().equals(other.getMs()))
            && (this.getXh() == null ? other.getXh() == null : this.getXh().equals(other.getXh()))
            && (this.getSjbmzbId() == null ? other.getSjbmzbId() == null : this.getSjbmzbId().equals(other.getSjbmzbId()))
            && (this.getYxbz() == null ? other.getYxbz() == null : this.getYxbz().equals(other.getYxbz()))
            && (this.getLrry() == null ? other.getLrry() == null : this.getLrry().equals(other.getLrry()))
            && (this.getLrsj() == null ? other.getLrsj() == null : this.getLrsj().equals(other.getLrsj()))
            && (this.getXgry() == null ? other.getXgry() == null : this.getXgry().equals(other.getXgry()))
            && (this.getXgsj() == null ? other.getXgsj() == null : this.getXgsj().equals(other.getXgsj()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMc() == null) ? 0 : getMc().hashCode());
        result = prime * result + ((getMs() == null) ? 0 : getMs().hashCode());
        result = prime * result + ((getXh() == null) ? 0 : getXh().hashCode());
        result = prime * result + ((getSjbmzbId() == null) ? 0 : getSjbmzbId().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}