package com.cssnj.ywgl.vo.xtzy;

import org.apache.commons.collections.list.CursorableLinkedList;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: duq
 * @Date: 2019/3/22 12:06
 */
public class RoleVo implements Serializable {

    private static final long serialVersionUID = 7061070244973323565L;

    private String id;

    private String qxbs;

    private String mc;

    private String ms;

    private Integer xh;

    private String sjjsId;

    private String yxbz;

    private String czbz;

    private String open;

    private String checked;

    private String chkDisabled;


    private List<RoleVo> childs = new CursorableLinkedList();

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

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public Integer getXh() {
        return xh;
    }

    public void setXh(Integer xh) {
        this.xh = xh;
    }

    public String getSjjsId() {
        return sjjsId;
    }

    public void setSjjsId(String sjjsId) {
        this.sjjsId = sjjsId;
    }

    public String getYxbz() {
        return yxbz;
    }

    public void setYxbz(String yxbz) {
        this.yxbz = yxbz;
    }


    public String getCzbz() {
        return czbz;
    }

    public void setCzbz(String czbz) {
        this.czbz = czbz;
    }

    public List<RoleVo> getChilds() {
        return childs;
    }

    public void setChilds(List<RoleVo> childs) {
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
