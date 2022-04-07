package com.yang.exception;

import com.yang.response.ResultCode;
import com.yang.response.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 自定义异常APIException
     */
    @ExceptionHandler(APIException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO<Object> APIExceptionHandler(APIException e) {
        log.error("自定义异常");
        return new ResultVO<>(e);
    }

    /**
     * 方法参数错误异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResultVO<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("方法参数错误异常");
        List<String> list = new ArrayList<>();        // 从异常对象中拿到ObjectError对象
        if (!e.getBindingResult().getAllErrors().isEmpty()) {
            for (ObjectError error : e.getBindingResult().getAllErrors()) {
                list.add(error.getDefaultMessage());
            }
        }
        // 然后提取错误提示信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, list);
    }
}