package com.cdd.self01.common.api;

import java.util.List;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class PageRequest {
    private long current;
    private long size;
    private List<Sort> sort;

    public PageRequest() {
    }

    public long getCurrent() {
        return this.current;
    }

    public long getSize() {
        return this.size;
    }

    public List<Sort> getSort() {
        return this.sort;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setSort(List<Sort> sort) {
        this.sort = sort;
    }
}
