package com.uxunchina.changsha.common.aut.pojo.dto;

import java.io.Serializable;

/**
 * Created by leo on 2017/7/11.
 */
public class HttpJsonResponse implements Serializable {
    public HttpJsonResponse() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final long serialVersionUID = 1L;

    private String code;
    private Object data;


    public HttpJsonResponse(String code, Object data) {
        super();
        this.code = code;
        this.data = data;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

}
