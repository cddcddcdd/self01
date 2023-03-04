package com.cdd.self01.common.api;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public enum SortDirection {
    ASC,
    DESC;

    private SortDirection() {
    }

    public String toString() {
        return this.name();
    }
}
