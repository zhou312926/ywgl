package com.cssnj.ywgl.domain.jnkp;

import java.io.Serializable;
import java.util.Date;

public class Dsdp implements Serializable {
    private String id;

    private String ssgxId;

    private Float gtnlpf;

    private String gtnlpj;

    private Float ywnlpf;

    private String ywnlpj;

    private Float qtpf;

    private String qtpj;

    private String bmzbId;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public Dsdp(String id, String ssgxId, Float gtnlpf, String gtnlpj, Float ywnlpf, String ywnlpj, Float qtpf, String qtpj, String bmzbId, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.ssgxId = ssgxId;
        this.gtnlpf = gtnlpf;
        this.gtnlpj = gtnlpj;
        this.ywnlpf = ywnlpf;
        this.ywnlpj = ywnlpj;
        this.qtpf = qtpf;
        this.qtpj = qtpj;
        this.bmzbId = bmzbId;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public Dsdp() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSsgxId() {
        return ssgxId;
    }

    public void setSsgxId(String ssgxId) {
        this.ssgxId = ssgxId == null ? null : ssgxId.trim();
    }

    public Float getGtnlpf() {
        return gtnlpf;
    }

    public void setGtnlpf(Float gtnlpf) {
        this.gtnlpf = gtnlpf;
    }

    public String getGtnlpj() {
        return gtnlpj;
    }

    public void setGtnlpj(String gtnlpj) {
        this.gtnlpj = gtnlpj == null ? null : gtnlpj.trim();
    }

    public Float getYwnlpf() {
        return ywnlpf;
    }

    public void setYwnlpf(Float ywnlpf) {
        this.ywnlpf = ywnlpf;
    }

    public String getYwnlpj() {
        return ywnlpj;
    }

    public void setYwnlpj(String ywnlpj) {
        this.ywnlpj = ywnlpj == null ? null : ywnlpj.trim();
    }

    public Float getQtpf() {
        return qtpf;
    }

    public void setQtpf(Float qtpf) {
        this.qtpf = qtpf;
    }

    public String getQtpj() {
        return qtpj;
    }

    public void setQtpj(String qtpj) {
        this.qtpj = qtpj == null ? null : qtpj.trim();
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
        Dsdp other = (Dsdp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSsgxId() == null ? other.getSsgxId() == null : this.getSsgxId().equals(other.getSsgxId()))
            && (this.getGtnlpf() == null ? other.getGtnlpf() == null : this.getGtnlpf().equals(other.getGtnlpf()))
            && (this.getGtnlpj() == null ? other.getGtnlpj() == null : this.getGtnlpj().equals(other.getGtnlpj()))
            && (this.getYwnlpf() == null ? other.getYwnlpf() == null : this.getYwnlpf().equals(other.getYwnlpf()))
            && (this.getYwnlpj() == null ? other.getYwnlpj() == null : this.getYwnlpj().equals(other.getYwnlpj()))
            && (this.getQtpf() == null ? other.getQtpf() == null : this.getQtpf().equals(other.getQtpf()))
            && (this.getQtpj() == null ? other.getQtpj() == null : this.getQtpj().equals(other.getQtpj()))
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
        result = prime * result + ((getSsgxId() == null) ? 0 : getSsgxId().hashCode());
        result = prime * result + ((getGtnlpf() == null) ? 0 : getGtnlpf().hashCode());
        result = prime * result + ((getGtnlpj() == null) ? 0 : getGtnlpj().hashCode());
        result = prime * result + ((getYwnlpf() == null) ? 0 : getYwnlpf().hashCode());
        result = prime * result + ((getYwnlpj() == null) ? 0 : getYwnlpj().hashCode());
        result = prime * result + ((getQtpf() == null) ? 0 : getQtpf().hashCode());
        result = prime * result + ((getQtpj() == null) ? 0 : getQtpj().hashCode());
        result = prime * result + ((getBmzbId() == null) ? 0 : getBmzbId().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}