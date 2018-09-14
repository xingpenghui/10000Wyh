package com.wyh10000.domain;

import java.io.Serializable;
import java.util.Date;

public class UserDetail implements Serializable {
    private Integer id;

    private String realname;

    private String sex;

    private String cardaddress;

    private String cardno;

    private Date birthday;

    private Date createdate;

    private Integer flag;

    private String idimage1;

    private String idimage2;

    private String idimage3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCardaddress() {
        return cardaddress;
    }

    public void setCardaddress(String cardaddress) {
        this.cardaddress = cardaddress == null ? null : cardaddress.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getIdimage1() {
        return idimage1;
    }

    public void setIdimage1(String idimage1) {
        this.idimage1 = idimage1 == null ? null : idimage1.trim();
    }

    public String getIdimage2() {
        return idimage2;
    }

    public void setIdimage2(String idimage2) {
        this.idimage2 = idimage2 == null ? null : idimage2.trim();
    }

    public String getIdimage3() {
        return idimage3;
    }

    public void setIdimage3(String idimage3) {
        this.idimage3 = idimage3 == null ? null : idimage3.trim();
    }
}