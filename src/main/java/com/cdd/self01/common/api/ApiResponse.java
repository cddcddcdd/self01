package com.cdd.self01.common.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private long duration;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date operateTime;

    public ApiResponse() {
    }

    public static <T> ApiResponse<T> ok(T body) {
        ApiResponse<T> response = new ApiResponse();
        response.setCode(0);
        response.setData(body);
        return response;
    }

    public static <T> ApiResponse<T> fail(String message) {
        return fail(1, message);
    }

    public static <T> ApiResponse<T> fail(int code, String message) {
        ApiResponse<T> response = new ApiResponse();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public long getDuration() {
        return this.duration;
    }

    public Date getOperateTime() {
        return this.operateTime;
    }

    @Override
    public String toString() {
        return "ApiResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", duration=" + this.getDuration() + ", operateTime=" + this.getOperateTime() + ")";
    }

}
