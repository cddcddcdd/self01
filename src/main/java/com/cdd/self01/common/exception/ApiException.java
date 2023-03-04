package com.cdd.self01.common.exception;

import java.util.Arrays;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class ApiException extends RuntimeException{
    private int apiResultStatus;
    private Object[] messageResourceArgs;

    public ApiException(int apiResultStatus) {
        this.apiResultStatus = apiResultStatus;
    }

    public ApiException(int apiResultStatus, Throwable e) {
        super(e);
        this.apiResultStatus = apiResultStatus;
    }

    public ApiException(int apiResultStatus, Object[] messageResourceArgs) {
        this.apiResultStatus = apiResultStatus;
        this.messageResourceArgs = messageResourceArgs;
    }

    public ApiException(int apiResultStatus, Object[] messageResourceArgs, Throwable e) {
        super(e);
        this.apiResultStatus = apiResultStatus;
        this.messageResourceArgs = messageResourceArgs;
    }

    public int getApiResultStatus() {
        return this.apiResultStatus;
    }

    public Object[] getMessageResourceArgs() {
        return this.messageResourceArgs;
    }

    public void setApiResultStatus(int apiResultStatus) {
        this.apiResultStatus = apiResultStatus;
    }

    public void setMessageResourceArgs(Object[] messageResourceArgs) {
        this.messageResourceArgs = messageResourceArgs;
    }

    @Override
    public String toString() {
        return "ApiException(apiResultStatus=" + this.getApiResultStatus() + ", messageResourceArgs=" + Arrays.deepToString(this.getMessageResourceArgs()) + ")";
    }
}
