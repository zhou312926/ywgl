package com.cssnj.ywgl.domain.xtdm;

import java.io.Serializable;

public class Zhlx implements Serializable {
    private String dm;

    private String mc;

    private String yxbz;

    private static final long serialVersionUID = 1L;

    public Zhlx(String dm, String mc, String yxbz) {
        this.dm = dm;
        this.mc = mc;
        this.yxbz = yxbz;
    }

    public Zhlx() {
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
        Zhlx other = (Zhlx) that;
        return (this.getDm() == null ? other.getDm() == null : this.getDm().equals(other.getDm()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getYxbz() == null ? other.getYxbz() == null : this.getYxbz().equals(other.getYxbz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDm() == null) ? 0 : getDm().hashCode());
        result = prime * result + ((getMc() == null) ? 0 : getMc().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        return result;
    }
}