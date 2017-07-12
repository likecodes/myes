package com.uxunchina.changsha.common.base.exception;

/**
 * 业务异常功能类
 * Created by leo on 2017/7/12.
 */
public class BusinessException extends Exception {
    private String code;//错误码
    private String msg;//错误信息
    public BusinessException() {
        super();
    }
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String code,String message) {
        super(message);
        this.code=code;
        this.msg=message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
