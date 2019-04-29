package com.cssnj.ywgl.domain.jnkp;

import java.io.Serializable;
import java.util.Date;

public class Xsxx implements Serializable {
    private String id;

    private String dsId;

    private String yhId;

    private String bz;

    private Date jzrq;

    private String yxbz;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Xsxx(String id, String dsId, String yhId, String bz, Date jzrq, String yxbz, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.dsId = dsId;
        this.yhId = yhId;
        this.bz = bz;
        this.jzrq = jzrq;
        this.yxbz = yxbz;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Xsxx() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDsId() {
        return dsId;
    }

    public void setDsId(String dsId) {
        this.dsId = dsId == null ? null : dsId.trim();
    }

    public String getYhId() {
        return yhId;
    }

    public void setYhId(String yhId) {
        this.yhId = yhId == null ? null : yhId.trim();
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Date getJzrq() {
        return jzrq;
    }

    public void setJzrq(Date jzrq) {
        this.jzrq = jzrq;
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
        Xsxx other = (Xsxx) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDsId() == null ? other.getDsId() == null : this.getDsId().equals(other.getDsId()))
            && (this.getYhId() == null ? other.getYhId() == null : this.getYhId().equals(other.getYhId()))
            && (this.getBz() == null ? other.getBz() == null : this.getBz().equals(other.getBz()))
            && (this.getJzrq() == null ? other.getJzrq() == null : this.getJzrq().equals(other.getJzrq()))
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
        result = prime * result + ((getDsId() == null) ? 0 : getDsId().hashCode());
        result = prime * result + ((getYhId() == null) ? 0 : getYhId().hashCode());
        result = prime * result + ((getBz() == null) ? 0 : getBz().hashCode());
        result = prime * result + ((getJzrq() == null) ? 0 : getJzrq().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}