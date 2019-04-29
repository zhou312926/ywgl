package com.cssnj.ywgl.domain.ywfw;

import java.io.Serializable;
import java.util.Date;

public class Wtfj implements Serializable {
    private String id;

    private String mc;

    private String fjhz;

    private String url;

    private String icon;

    private String wtxxId;

    private String bmzbId;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Wtfj(String id, String mc, String fjhz, String url, String icon, String wtxxId, String bmzbId, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.mc = mc;
        this.fjhz = fjhz;
        this.url = url;
        this.icon = icon;
        this.wtxxId = wtxxId;
        this.bmzbId = bmzbId;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Wtfj() {
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

    public String getFjhz() {
        return fjhz;
    }

    public void setFjhz(String fjhz) {
        this.fjhz = fjhz == null ? null : fjhz.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getWtxxId() {
        return wtxxId;
    }

    public void setWtxxId(String wtxxId) {
        this.wtxxId = wtxxId == null ? null : wtxxId.trim();
    }

    public String getBmzbId() {
        return bmzbId;
    }

    public void setBmzbId(String bmzbId) {
        this.bmzbId = bmzbId == null ? null : bmzbId.trim();
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
        Wtfj other = (Wtfj) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getFjhz() == null ? other.getFjhz() == null : this.getFjhz().equals(other.getFjhz()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getWtxxId() == null ? other.getWtxxId() == null : this.getWtxxId().equals(other.getWtxxId()))
            && (this.getBmzbId() == null ? other.getBmzbId() == null : this.getBmzbId().equals(other.getBmzbId()))
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
        result = prime * result + ((getFjhz() == null) ? 0 : getFjhz().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getWtxxId() == null) ? 0 : getWtxxId().hashCode());
        result = prime * result + ((getBmzbId() == null) ? 0 : getBmzbId().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}