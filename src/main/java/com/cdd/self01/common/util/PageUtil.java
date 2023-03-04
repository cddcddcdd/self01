package com.cdd.self01.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdd.self01.common.api.PageRequest;
import com.cdd.self01.common.api.PageResponse;
import com.cdd.self01.common.api.Sort;
import com.cdd.self01.common.api.SortDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class PageUtil {
    public PageUtil() {
    }

    public static <T> Page<T> toMybatisPlusPage(PageRequest pageRequest) {
        Page<T> page = new Page();
        page.setSize(pageRequest.getSize());
        page.setCurrent(pageRequest.getCurrent());
        if (pageRequest.getSort() != null && !pageRequest.getSort().isEmpty()) {
            List<OrderItem> orderItems = new ArrayList();

            for (Sort sort : pageRequest.getSort()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setAsc(SortDirection.ASC.equals(sort.getDirection()));
                orderItem.setColumn(sort.getProperty());
                orderItems.add(orderItem);
            }

            page.setOrders(orderItems);
        } else {
            page.setOrders(Arrays.asList(OrderItem.asc("id")));
        }

        return page;
    }

    public static <T, E> PageResponse<T> fromMybatisPlusPage(IPage<E> page, Function<E, T> function) {
        PageResponse<T> pageResponse = new PageResponse();
        pageResponse.setCurrent(page.getCurrent());
        pageResponse.setSize(page.getSize());
        pageResponse.setTotal(page.getTotal());
        pageResponse.setData(page.getRecords().stream().map(function).collect(Collectors.toList()));
        return pageResponse;
    }
}
