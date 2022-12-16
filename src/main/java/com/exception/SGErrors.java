package com.exception;


public enum SGErrors {
    /*1开头表示公用错误码,2开头表示相关业务错误码专用,其它错误码定义请参照此规范*/
    ILLEGAL_PARAMS(1001, "非法入参"),
    CONTENT_TYPE_ERROR(1002, "Content_Type不正确"),
    REMOTE_ERROR(1003, "远程调用异常"),
    AGAINST_OPERATION(1004, "请勿重复操作"),
    UNKNOWN_ERROR(1999, "系统异常"),

    //目前业务通用错误码，仅使用其code，错误信息需要按照实际情况写
    BIZ_ERROR(300, "业务异常"),

;
    private int code;
    private String desc;

    SGErrors(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
