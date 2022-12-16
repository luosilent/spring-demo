package com.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 6770611699122579987L;
    private int code;
    private String desc;

    public BusinessException(int code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }

    public BusinessException(SGErrors errors) {
        super(errors.getDesc());
        this.code = errors.getCode();
        this.desc = errors.getDesc();
    }

    public BusinessException(SGErrors errors, String message) {
        super(message);
        this.code = errors.getCode();
        this.desc = message;
    }

    public BusinessException(String message) {
        super(message);
        this.code = SGErrors.BIZ_ERROR.getCode();
        this.desc = message;
    }

    public BusinessException(Throwable throwable) {
        super(throwable.getMessage());
        this.code = SGErrors.UNKNOWN_ERROR.getCode();
        this.desc = throwable.getMessage();
    }

}
