package com.wyh10000.domain;

import java.io.Serializable;
import java.util.Date;

public class Rank implements Serializable {
    private Integer id;

    private Integer uid;

    private Integer type;

    private String rankimages;

    private Date createdate;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRankimages() {
        return rankimages;
    }

    public void setRankimages(String rankimages) {
        this.rankimages = rankimages == null ? null : rankimages.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}