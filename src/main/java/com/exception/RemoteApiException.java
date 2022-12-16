package com.exception;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 调用其他服务接口异常
 *
 * @author lizhenjiang
 * @date 2020/6/15
 */
@Setter
@Getter
@ToString
public class RemoteApiException extends Exception {

    private static final long serialVersionUID = 6770611699122579987L;
    private int code;
    private String desc;

    public RemoteApiException(int code, String desc) {
        super("RemoteApiException -> code : " + code + ", desc : " + desc);
        this.code = code;
        this.desc = desc;
    }

    public RemoteApiException(SGErrors errors) {
        super("RemoteApiException -> code : " + errors.getCode() + ", desc : " + errors.getDesc());
        this.code = errors.getCode();
        this.desc = errors.getDesc();
    }

    public RemoteApiException(SGErrors errors, String message) {
        super("RemoteApiException -> code : " + errors.getCode() + ", desc : " + message);
        this.code = errors.getCode();
        this.desc = message;
    }

    public RemoteApiException(String message) {
        super("RemoteApiException -> code : " + SGErrors.REMOTE_ERROR.getCode() + ", desc : " + message);
        this.code = SGErrors.BIZ_ERROR.getCode();
        this.desc = message;
    }

    public RemoteApiException(Throwable throwable) {
        super("RemoteApiException -> code : " + SGErrors.UNKNOWN_ERROR.getCode() + ", desc : " + throwable.getMessage());
        this.code = SGErrors.UNKNOWN_ERROR.getCode();
        this.desc = throwable.getMessage();
    }
}
