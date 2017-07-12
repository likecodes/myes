package com.uxunchina.changsha.common.base.vo;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by leo on 2017/7/12.
 */
public class ResponseVo<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    private String retcode;
    private String retmsg;
    private T data;


    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
