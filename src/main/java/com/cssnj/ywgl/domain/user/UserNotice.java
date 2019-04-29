package com.cssnj.ywgl.domain.user;

import java.io.Serializable;
import java.util.Date;

public class UserNotice implements Serializable {
    private String id;

    private String yhId;

    private String tzggId;

    private String qrbz;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public UserNotice(String id, String yhId, String tzggId, String qrbz, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.yhId = yhId;
        this.tzggId = tzggId;
        this.qrbz = qrbz;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public UserNotice() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getYhId() {
        return yhId;
    }

    public void setYhId(String yhId) {
        this.yhId = yhId == null ? null : yhId.trim();
    }

    public String getTzggId() {
        return tzggId;
    }

    public void setTzggId(String tzggId) {
        this.tzggId = tzggId == null ? null : tzggId.trim();
    }

    public String getQrbz() {
        return qrbz;
    }

    public void setQrbz(String qrbz) {
        this.qrbz = qrbz == null ? null : qrbz.trim();
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
        UserNotice other = (UserNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYhId() == null ? other.getYhId() == null : this.getYhId().equals(other.getYhId()))
            && (this.getTzggId() == null ? other.getTzggId() == null : this.getTzggId().equals(other.getTzggId()))
            && (this.getQrbz() == null ? other.getQrbz() == null : this.getQrbz().equals(other.getQrbz()))
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
        result = prime * result + ((getYhId() == null) ? 0 : getYhId().hashCode());
        result = prime * result + ((getTzggId() == null) ? 0 : getTzggId().hashCode());
        result = prime * result + ((getQrbz() == null) ? 0 : getQrbz().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}