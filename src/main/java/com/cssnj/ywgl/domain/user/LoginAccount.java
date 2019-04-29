package com.cssnj.ywgl.domain.user;

import java.io.Serializable;
import java.util.Date;

public class LoginAccount implements Serializable {
    private String id;

    private String dlzh;

    private String mm;

    private String zhlxDm;

    private String yhId;

    private String yxbz;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public LoginAccount(String id, String dlzh, String mm, String zhlxDm, String yhId, String yxbz, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.dlzh = dlzh;
        this.mm = mm;
        this.zhlxDm = zhlxDm;
        this.yhId = yhId;
        this.yxbz = yxbz;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public LoginAccount() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDlzh() {
        return dlzh;
    }

    public void setDlzh(String dlzh) {
        this.dlzh = dlzh == null ? null : dlzh.trim();
    }

    public String getMm() {
        return mm;
    }

    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
    }

    public String getZhlxDm() {
        return zhlxDm;
    }

    public void setZhlxDm(String zhlxDm) {
        this.zhlxDm = zhlxDm == null ? null : zhlxDm.trim();
    }

    public String getYhId() {
        return yhId;
    }

    public void setYhId(String yhId) {
        this.yhId = yhId == null ? null : yhId.trim();
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
        LoginAccount other = (LoginAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDlzh() == null ? other.getDlzh() == null : this.getDlzh().equals(other.getDlzh()))
            && (this.getMm() == null ? other.getMm() == null : this.getMm().equals(other.getMm()))
            && (this.getZhlxDm() == null ? other.getZhlxDm() == null : this.getZhlxDm().equals(other.getZhlxDm()))
            && (this.getYhId() == null ? other.getYhId() == null : this.getYhId().equals(other.getYhId()))
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
        result = prime * result + ((getDlzh() == null) ? 0 : getDlzh().hashCode());
        result = prime * result + ((getMm() == null) ? 0 : getMm().hashCode());
        result = prime * result + ((getZhlxDm() == null) ? 0 : getZhlxDm().hashCode());
        result = prime * result + ((getYhId() == null) ? 0 : getYhId().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}