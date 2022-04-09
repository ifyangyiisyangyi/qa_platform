package com.yang.interceptor;

import com.yang.response.ResultCode;
import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class APIException extends RuntimeException {
    private final int code;
    private final String msg;

    public APIException() {
        this(ResultCode.FAILED);
    }

    public APIException(String msg) {
        this(ResultCode.FAILED, msg);
    }

    public APIException(ResultCode failed) {
        this.code = failed.getCode();
        this.msg = failed.getMsg();
    }

    public APIException(ResultCode resultCode, String msg) {
        this.code = resultCode.getCode();
        this.msg = msg;
    }
}
