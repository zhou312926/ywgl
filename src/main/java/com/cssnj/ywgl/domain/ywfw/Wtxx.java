package com.cssnj.ywgl.domain.ywfw;

import java.io.Serializable;
import java.util.Date;

public class Wtxx implements Serializable {
    private String id;

    private String bt;

    private String ms;

    private String wtlxDm;

    private String yyxtDm;

    private String ywmkDm;

    private String wtztDm;

    private String clfa;

    private String bmzbId;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Wtxx(String id, String bt, String ms, String wtlxDm, String yyxtDm, String ywmkDm, String wtztDm, String clfa, String bmzbId, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.bt = bt;
        this.ms = ms;
        this.wtlxDm = wtlxDm;
        this.yyxtDm = yyxtDm;
        this.ywmkDm = ywmkDm;
        this.wtztDm = wtztDm;
        this.clfa = clfa;
        this.bmzbId = bmzbId;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Wtxx() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt == null ? null : bt.trim();
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms == null ? null : ms.trim();
    }

    public String getWtlxDm() {
        return wtlxDm;
    }

    public void setWtlxDm(String wtlxDm) {
        this.wtlxDm = wtlxDm == null ? null : wtlxDm.trim();
    }

    public String getYyxtDm() {
        return yyxtDm;
    }

    public void setYyxtDm(String yyxtDm) {
        this.yyxtDm = yyxtDm == null ? null : yyxtDm.trim();
    }

    public String getYwmkDm() {
        return ywmkDm;
    }

    public void setYwmkDm(String ywmkDm) {
        this.ywmkDm = ywmkDm == null ? null : ywmkDm.trim();
    }

    public String getWtztDm() {
        return wtztDm;
    }

    public void setWtztDm(String wtztDm) {
        this.wtztDm = wtztDm == null ? null : wtztDm.trim();
    }

    public String getClfa() {
        return clfa;
    }

    public void setClfa(String clfa) {
        this.clfa = clfa == null ? null : clfa.trim();
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
        Wtxx other = (Wtxx) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBt() == null ? other.getBt() == null : this.getBt().equals(other.getBt()))
            && (this.getMs() == null ? other.getMs() == null : this.getMs().equals(other.getMs()))
            && (this.getWtlxDm() == null ? other.getWtlxDm() == null : this.getWtlxDm().equals(other.getWtlxDm()))
            && (this.getYyxtDm() == null ? other.getYyxtDm() == null : this.getYyxtDm().equals(other.getYyxtDm()))
            && (this.getYwmkDm() == null ? other.getYwmkDm() == null : this.getYwmkDm().equals(other.getYwmkDm()))
            && (this.getWtztDm() == null ? other.getWtztDm() == null : this.getWtztDm().equals(other.getWtztDm()))
            && (this.getClfa() == null ? other.getClfa() == null : this.getClfa().equals(other.getClfa()))
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
        result = prime * result + ((getBt() == null) ? 0 : getBt().hashCode());
        result = prime * result + ((getMs() == null) ? 0 : getMs().hashCode());
        result = prime * result + ((getWtlxDm() == null) ? 0 : getWtlxDm().hashCode());
        result = prime * result + ((getYyxtDm() == null) ? 0 : getYyxtDm().hashCode());
        result = prime * result + ((getYwmkDm() == null) ? 0 : getYwmkDm().hashCode());
        result = prime * result + ((getWtztDm() == null) ? 0 : getWtztDm().hashCode());
        result = prime * result + ((getClfa() == null) ? 0 : getClfa().hashCode());
        result = prime * result + ((getBmzbId() == null) ? 0 : getBmzbId().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}