package com.wyh10000.common.vo;

/**
 *@Author feri
 *@Date Created in 2018/9/19 16:38
 */
public class MsgVo<T> {
    private int type;//标记
    private T obj;//具体的对象信息

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
