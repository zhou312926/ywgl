package com.cssnj.ywgl.domain.ywfw;

import java.io.Serializable;
import java.util.Date;

public class Ywjb implements Serializable {
    private String id;

    private String bt;

    private String ms;

    private String yyxtDm;

    private String jbnr;

    private String bmzbId;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Ywjb(String id, String bt, String ms, String yyxtDm, String jbnr, String bmzbId, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.bt = bt;
        this.ms = ms;
        this.yyxtDm = yyxtDm;
        this.jbnr = jbnr;
        this.bmzbId = bmzbId;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Ywjb() {
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

    public String getYyxtDm() {
        return yyxtDm;
    }

    public void setYyxtDm(String yyxtDm) {
        this.yyxtDm = yyxtDm == null ? null : yyxtDm.trim();
    }

    public String getJbnr() {
        return jbnr;
    }

    public void setJbnr(String jbnr) {
        this.jbnr = jbnr == null ? null : jbnr.trim();
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
        Ywjb other = (Ywjb) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBt() == null ? other.getBt() == null : this.getBt().equals(other.getBt()))
            && (this.getMs() == null ? other.getMs() == null : this.getMs().equals(other.getMs()))
            && (this.getYyxtDm() == null ? other.getYyxtDm() == null : this.getYyxtDm().equals(other.getYyxtDm()))
            && (this.getJbnr() == null ? other.getJbnr() == null : this.getJbnr().equals(other.getJbnr()))
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
        result = prime * result + ((getYyxtDm() == null) ? 0 : getYyxtDm().hashCode());
        result = prime * result + ((getJbnr() == null) ? 0 : getJbnr().hashCode());
        result = prime * result + ((getBmzbId() == null) ? 0 : getBmzbId().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}