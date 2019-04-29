package com.cssnj.ywgl.domain.ywdm;

import java.io.Serializable;

public class Ywmk implements Serializable {
    private String dm;

    private String mc;

    private String yyxtDm;

    private String yxbz;

    private static final long serialVersionUID = 1L;

    public Ywmk(String dm, String mc, String yyxtDm, String yxbz) {
        this.dm = dm;
        this.mc = mc;
        this.yyxtDm = yyxtDm;
        this.yxbz = yxbz;
    }

    public Ywmk() {
        super();
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm == null ? null : dm.trim();
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc == null ? null : mc.trim();
    }

    public String getYyxtDm() {
        return yyxtDm;
    }

    public void setYyxtDm(String yyxtDm) {
        this.yyxtDm = yyxtDm == null ? null : yyxtDm.trim();
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz == null ? null : yxbz.trim();
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
        Ywmk other = (Ywmk) that;
        return (this.getDm() == null ? other.getDm() == null : this.getDm().equals(other.getDm()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getYyxtDm() == null ? other.getYyxtDm() == null : this.getYyxtDm().equals(other.getYyxtDm()))
            && (this.getYxbz() == null ? other.getYxbz() == null : this.getYxbz().equals(other.getYxbz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDm() == null) ? 0 : getDm().hashCode());
        result = prime * result + ((getMc() == null) ? 0 : getMc().hashCode());
        result = prime * result + ((getYyxtDm() == null) ? 0 : getYyxtDm().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        return result;
    }
}