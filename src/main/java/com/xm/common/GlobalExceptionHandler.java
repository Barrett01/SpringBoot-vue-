package com.xm.common;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice //全局控制器通知，会拦截所有来自控制器的异常
public class GlobalExceptionHandler {

    //捕获指定类型的异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse paramExceptionHandler(MethodArgumentNotValidException e) {
        //获取所有字段的异常
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessages = "";
        for(FieldError fieldError: fieldErrors){
            errorMessages += fieldError.getDefaultMessage()  + " , ";
        }
        return new ApiResponse(false, errorMessages);
    }

}

