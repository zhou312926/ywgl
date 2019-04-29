package com.cssnj.ywgl.domain.xtzy;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    private String id;

    private String qxbs;

    private String mc;

    private String ms;

    private Integer xh;

    private String sjjsId;

    private String yxbz;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Role(String id, String qxbs, String mc, String ms, Integer xh, String sjjsId, String yxbz, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.qxbs = qxbs;
        this.mc = mc;
        this.ms = ms;
        this.xh = xh;
        this.sjjsId = sjjsId;
        this.yxbz = yxbz;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Role() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQxbs() {
        return qxbs;
    }

    public void setQxbs(String qxbs) {
        this.qxbs = qxbs == null ? null : qxbs.trim();
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

    public String getSjjsId() {
        return sjjsId;
    }

    public void setSjjsId(String sjjsId) {
        this.sjjsId = sjjsId == null ? null : sjjsId.trim();
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
        Role other = (Role) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQxbs() == null ? other.getQxbs() == null : this.getQxbs().equals(other.getQxbs()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getMs() == null ? other.getMs() == null : this.getMs().equals(other.getMs()))
            && (this.getXh() == null ? other.getXh() == null : this.getXh().equals(other.getXh()))
            && (this.getSjjsId() == null ? other.getSjjsId() == null : this.getSjjsId().equals(other.getSjjsId()))
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
        result = prime * result + ((getQxbs() == null) ? 0 : getQxbs().hashCode());
        result = prime * result + ((getMc() == null) ? 0 : getMc().hashCode());
        result = prime * result + ((getMs() == null) ? 0 : getMs().hashCode());
        result = prime * result + ((getXh() == null) ? 0 : getXh().hashCode());
        result = prime * result + ((getSjjsId() == null) ? 0 : getSjjsId().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}