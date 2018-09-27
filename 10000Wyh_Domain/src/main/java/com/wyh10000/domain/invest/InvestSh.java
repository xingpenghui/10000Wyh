package com.wyh10000.domain.invest;

import java.util.Date;

public class InvestSh {
    private Integer id;

    private Integer iid;

    private Integer aid;

    private Date shdate;

    private Integer flag;

    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Date getShdate() {
        return shdate;
    }

    public void setShdate(Date shdate) {
        this.shdate = shdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}