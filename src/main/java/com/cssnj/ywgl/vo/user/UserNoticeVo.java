package com.cssnj.ywgl.vo.user;

import java.io.Serializable;

/**
 * @Auther: duq
 * @Date: 2019/4/9 22:17
 */
public class UserNoticeVo implements Serializable {

    private static final long serialVersionUID = 3437760401026927935L;
    private String id;

    private String yhId;

    private String tzggId;

    private String lrry;

    private String lrsj;

    private String xgry;

    private String xgsj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYhId() {
        return yhId;
    }

    public void setYhId(String yhId) {
        this.yhId = yhId;
    }

    public String getTzggId() {
        return tzggId;
    }

    public void setTzggId(String tzggId) {
        this.tzggId = tzggId;
    }

    public String getLrry() {
        return lrry;
    }

    public void setLrry(String lrry) {
        this.lrry = lrry;
    }

    public String getLrsj() {
        return lrsj;
    }

    public void setLrsj(String lrsj) {
        this.lrsj = lrsj;
    }

    public String getXgry() {
        return xgry;
    }

    public void setXgry(String xgry) {
        this.xgry = xgry;
    }

    public String getXgsj() {
        return xgsj;
    }

    public void setXgsj(String xgsj) {
        this.xgsj = xgsj;
    }
}
