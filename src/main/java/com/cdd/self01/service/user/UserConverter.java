package com.cdd.self01.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cdd.self01.dto.user.request.ListUserReq;
import com.cdd.self01.repository.po.UserPO;
import org.springframework.util.StringUtils;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
public class UserConverter {
    public static LambdaQueryWrapper<UserPO> queryWrapper(ListUserReq req) {
        LambdaQueryWrapper<UserPO> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(!StringUtils.isEmpty(req.getName()), UserPO::getName, req.getName());
        return queryWrapper;
    }
}
