package com.wyh10000.common.result;

import java.io.Serializable;

/**
 *@Author feri
 *@Date Created in 2018/9/4 16:27
 */
public class R implements Serializable {
    private int code;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R() {
    }


    public static R setOK(){
        return new R(1,"OK");
    }
    public static R setERROR(){
        return new R(2,"ERROR");
    }

}
