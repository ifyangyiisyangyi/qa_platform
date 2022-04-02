package com.yang.response;

import com.yang.exception.APIException;
import lombok.Data;

@Data
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;


    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(APIException e) {
        this.code = e.getCode();
        this.msg = e.getMsg();
    }

    public ResultVO(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
