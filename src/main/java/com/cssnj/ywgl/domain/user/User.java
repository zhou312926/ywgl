package com.cssnj.ywgl.domain.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String id;

    private String xm;

    private String xb;

    private Date csrq;

    private String yddh;

    private String gddh;

    private String dzyx;

    private String lx;

    private String bmzbId;

    private String yxbz;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public User(String id, String xm, String xb, Date csrq, String yddh, String gddh, String dzyx, String lx, String bmzbId, String yxbz, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.xm = xm;
        this.xb = xb;
        this.csrq = csrq;
        this.yddh = yddh;
        this.gddh = gddh;
        this.dzyx = dzyx;
        this.lx = lx;
        this.bmzbId = bmzbId;
        this.yxbz = yxbz;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public User() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb == null ? null : xb.trim();
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getYddh() {
        return yddh;
    }

    public void setYddh(String yddh) {
        this.yddh = yddh == null ? null : yddh.trim();
    }

    public String getGddh() {
        return gddh;
    }

    public void setGddh(String gddh) {
        this.gddh = gddh == null ? null : gddh.trim();
    }

    public String getDzyx() {
        return dzyx;
    }

    public void setDzyx(String dzyx) {
        this.dzyx = dzyx == null ? null : dzyx.trim();
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    public String getBmzbId() {
        return bmzbId;
    }

    public void setBmzbId(String bmzbId) {
        this.bmzbId = bmzbId == null ? null : bmzbId.trim();
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getXm() == null ? other.getXm() == null : this.getXm().equals(other.getXm()))
            && (this.getXb() == null ? other.getXb() == null : this.getXb().equals(other.getXb()))
            && (this.getCsrq() == null ? other.getCsrq() == null : this.getCsrq().equals(other.getCsrq()))
            && (this.getYddh() == null ? other.getYddh() == null : this.getYddh().equals(other.getYddh()))
            && (this.getGddh() == null ? other.getGddh() == null : this.getGddh().equals(other.getGddh()))
            && (this.getDzyx() == null ? other.getDzyx() == null : this.getDzyx().equals(other.getDzyx()))
            && (this.getLx() == null ? other.getLx() == null : this.getLx().equals(other.getLx()))
            && (this.getBmzbId() == null ? other.getBmzbId() == null : this.getBmzbId().equals(other.getBmzbId()))
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
        result = prime * result + ((getXm() == null) ? 0 : getXm().hashCode());
        result = prime * result + ((getXb() == null) ? 0 : getXb().hashCode());
        result = prime * result + ((getCsrq() == null) ? 0 : getCsrq().hashCode());
        result = prime * result + ((getYddh() == null) ? 0 : getYddh().hashCode());
        result = prime * result + ((getGddh() == null) ? 0 : getGddh().hashCode());
        result = prime * result + ((getDzyx() == null) ? 0 : getDzyx().hashCode());
        result = prime * result + ((getLx() == null) ? 0 : getLx().hashCode());
        result = prime * result + ((getBmzbId() == null) ? 0 : getBmzbId().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}