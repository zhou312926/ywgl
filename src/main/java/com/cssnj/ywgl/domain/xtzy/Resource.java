package com.cssnj.ywgl.domain.xtzy;

import java.io.Serializable;

public class Resource implements Serializable {
    private String id;

    private String qxbs;

    private String mc;

    private String jc;

    private String url;

    private String lx;

    private String dkfs;

    private String icon;

    private Integer xh;

    private String sjgncdId;

    private String yxbz;

    private static final long serialVersionUID = 1L;

    public Resource(String id, String qxbs, String mc, String jc, String url, String lx, String dkfs, String icon, Integer xh, String sjgncdId, String yxbz) {
        this.id = id;
        this.qxbs = qxbs;
        this.mc = mc;
        this.jc = jc;
        this.url = url;
        this.lx = lx;
        this.dkfs = dkfs;
        this.icon = icon;
        this.xh = xh;
        this.sjgncdId = sjgncdId;
        this.yxbz = yxbz;
    }

    public Resource() {
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

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc == null ? null : jc.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx == null ? null : lx.trim();
    }

    public String getDkfs() {
        return dkfs;
    }

    public void setDkfs(String dkfs) {
        this.dkfs = dkfs == null ? null : dkfs.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getSjgncdId() {
        return sjgncdId;
    }

    public void setSjgncdId(String sjgncdId) {
        this.sjgncdId = sjgncdId == null ? null : sjgncdId.trim();
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
        Resource other = (Resource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQxbs() == null ? other.getQxbs() == null : this.getQxbs().equals(other.getQxbs()))
            && (this.getMc() == null ? other.getMc() == null : this.getMc().equals(other.getMc()))
            && (this.getJc() == null ? other.getJc() == null : this.getJc().equals(other.getJc()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getLx() == null ? other.getLx() == null : this.getLx().equals(other.getLx()))
            && (this.getDkfs() == null ? other.getDkfs() == null : this.getDkfs().equals(other.getDkfs()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getXh() == null ? other.getXh() == null : this.getXh().equals(other.getXh()))
            && (this.getSjgncdId() == null ? other.getSjgncdId() == null : this.getSjgncdId().equals(other.getSjgncdId()))
            && (this.getYxbz() == null ? other.getYxbz() == null : this.getYxbz().equals(other.getYxbz()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQxbs() == null) ? 0 : getQxbs().hashCode());
        result = prime * result + ((getMc() == null) ? 0 : getMc().hashCode());
        result = prime * result + ((getJc() == null) ? 0 : getJc().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getLx() == null) ? 0 : getLx().hashCode());
        result = prime * result + ((getDkfs() == null) ? 0 : getDkfs().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getXh() == null) ? 0 : getXh().hashCode());
        result = prime * result + ((getSjgncdId() == null) ? 0 : getSjgncdId().hashCode());
        result = prime * result + ((getYxbz() == null) ? 0 : getYxbz().hashCode());
        return result;
    }
}