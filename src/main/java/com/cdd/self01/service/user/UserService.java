package com.cdd.self01.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdd.common.api.PageResponse;
import com.cdd.common.util.PageUtil;
import com.cdd.self01.convertor.Convertor;
import com.cdd.self01.dto.user.request.ListUserReq;
import com.cdd.self01.dto.user.response.ListUserResp;
import com.cdd.self01.repository.mapper.UserMapper;
import com.cdd.self01.repository.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public PageResponse<ListUserResp> listUser(ListUserReq req) {
        Page<UserPO> page = PageUtil.toMybatisPlusPage(req);
        LambdaQueryWrapper<UserPO> queryWrapper = UserConverter.queryWrapper(req);
        IPage<UserPO> result = userMapper.selectPage(page,queryWrapper);
        return PageUtil.fromMybatisPlusPage(result, userPO -> Convertor.poDto.toListUserResp(userPO));
    }

}
