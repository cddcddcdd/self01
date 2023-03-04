package com.cdd.self01.common.api;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class Sort {
    private String property;
    private SortDirection direction;

    public Sort() {
    }

    public String getProperty() {
        return this.property;
    }

    public SortDirection getDirection() {
        return this.direction;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }
}
