package com.cssnj.ywgl.vo.xtzy;

import com.cssnj.ywgl.domain.xtzy.Resource;
import org.apache.commons.collections.list.CursorableLinkedList;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: duq
 * @Date: 2019/3/22 15:57
 */
public class ResourceVo implements Serializable {

    private static final long serialVersionUID = -8795006361547862425L;
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

    private String open;

    private String checked;

    private String chkDisabled;


    private List<ResourceVo> childs = new CursorableLinkedList();

    public ResourceVo() {
    }

    public ResourceVo(Resource resource) {
        if (resource != null) {
            this.id = resource.getId();
            this.qxbs = resource.getQxbs();
            this.mc = resource.getMc();
            this.jc = resource.getJc();
            this.url = resource.getUrl();
            this.lx = resource.getLx();
            this.dkfs = resource.getDkfs();
            this.icon = resource.getIcon();
            this.xh = resource.getXh();
            this.sjgncdId = resource.getSjgncdId();
            this.yxbz = resource.getYxbz();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQxbs() {
        return qxbs;
    }

    public void setQxbs(String qxbs) {
        this.qxbs = qxbs;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }

    public String getDkfs() {
        return dkfs;
    }

    public void setDkfs(String dkfs) {
        this.dkfs = dkfs;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
        this.sjgncdId = sjgncdId;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }

    public List<ResourceVo> getChilds() {
        return childs;
    }

    public void setChilds(List<ResourceVo> childs) {
        this.childs = childs;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(String chkDisabled) {
        this.chkDisabled = chkDisabled;
    }
}
