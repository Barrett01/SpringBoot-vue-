package com.xm.common;

//统一响应对象
public class ApiResponse<T> {
    //代表请求是否被成功处理
    private boolean success;
    //响应字符串
    private String msg;
    //响应的具体数据
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ApiResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

