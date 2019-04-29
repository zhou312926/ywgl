package com.cssnj.ywgl.domain.user;

import java.io.Serializable;
import java.util.Date;

public class UserExtend implements Serializable {
    private String id;

    private Date dlsj;

    private Date scdlsj;

    private Integer dlcs;

    private String yhId;

    private String lrry;

    private Date lrsj;

    private String xgry;

    private Date xgsj;

    private static final long serialVersionUID = 1L;

    public UserExtend(String id, Date dlsj, Date scdlsj, Integer dlcs, String yhId, String lrry, Date lrsj, String xgry, Date xgsj) {
        this.id = id;
        this.dlsj = dlsj;
        this.scdlsj = scdlsj;
        this.dlcs = dlcs;
        this.yhId = yhId;
        this.lrry = lrry;
        this.lrsj = lrsj;
        this.xgry = xgry;
        this.xgsj = xgsj;
    }

    public UserExtend() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getDlsj() {
        return dlsj;
    }

    public void setDlsj(Date dlsj) {
        this.dlsj = dlsj;
    }

    public Date getScdlsj() {
        return scdlsj;
    }

    public void setScdlsj(Date scdlsj) {
        this.scdlsj = scdlsj;
    }

    public Integer getDlcs() {
        return dlcs;
    }

    public void setDlcs(Integer dlcs) {
        this.dlcs = dlcs;
    }

    public String getYhId() {
        return yhId;
    }

    public void setYhId(String yhId) {
        this.yhId = yhId == null ? null : yhId.trim();
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
        UserExtend other = (UserExtend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDlsj() == null ? other.getDlsj() == null : this.getDlsj().equals(other.getDlsj()))
            && (this.getScdlsj() == null ? other.getScdlsj() == null : this.getScdlsj().equals(other.getScdlsj()))
            && (this.getDlcs() == null ? other.getDlcs() == null : this.getDlcs().equals(other.getDlcs()))
            && (this.getYhId() == null ? other.getYhId() == null : this.getYhId().equals(other.getYhId()))
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
        result = prime * result + ((getDlsj() == null) ? 0 : getDlsj().hashCode());
        result = prime * result + ((getScdlsj() == null) ? 0 : getScdlsj().hashCode());
        result = prime * result + ((getDlcs() == null) ? 0 : getDlcs().hashCode());
        result = prime * result + ((getYhId() == null) ? 0 : getYhId().hashCode());
        result = prime * result + ((getLrry() == null) ? 0 : getLrry().hashCode());
        result = prime * result + ((getLrsj() == null) ? 0 : getLrsj().hashCode());
        result = prime * result + ((getXgry() == null) ? 0 : getXgry().hashCode());
        result = prime * result + ((getXgsj() == null) ? 0 : getXgsj().hashCode());
        return result;
    }
}