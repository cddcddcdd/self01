package com.cdd.self01.common.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class PageResponse<T> {
    private long total;
    private List<T> data;
    private long size;
    private long current;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    private Date operateTime;

    public PageResponse(PageRequest pageRequest) {
        this.current = pageRequest.getCurrent();
    }

    public long getTotal() {
        return this.total;
    }

    public List<T> getData() {
        return this.data;
    }

    public long getSize() {
        return this.size;
    }

    public long getCurrent() {
        return this.current;
    }

    public Date getOperateTime() {
        return this.operateTime;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss",
            timezone = "GMT+8"
    )
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public PageResponse() {
    }
}
