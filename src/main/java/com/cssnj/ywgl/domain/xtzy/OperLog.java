package com.cssnj.ywgl.domain.xtzy;

import java.io.Serializable;
import java.util.Date;

public class OperLog implements Serializable {
    private String id;

    private String czlxDm;

    private String cznr;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public OperLog(String id, String czlxDm, String cznr, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.czlxDm = czlxDm;
        this.cznr = cznr;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public OperLog() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCzlxDm() {
        return czlxDm;
    }

    public void setCzlxDm(String czlxDm) {
        this.czlxDm = czlxDm == null ? null : czlxDm.trim();
    }

    public String getCznr() {
        return cznr;
    }

    public void setCznr(String cznr) {
        this.cznr = cznr == null ? null : cznr.trim();
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
        OperLog other = (OperLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCzlxDm() == null ? other.getCzlxDm() == null : this.getCzlxDm().equals(other.getCzlxDm()))
            && (this.getCznr() == null ? other.getCznr() == null : this.getCznr().equals(other.getCznr()))
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
        result = prime * result + ((getCzlxDm() == null) ? 0 : getCzlxDm().hashCode());
        result = prime * result + ((getCznr() == null) ? 0 : getCznr().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}