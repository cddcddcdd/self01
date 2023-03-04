package com.cdd.self01.convertor;

import com.cdd.self01.dto.user.response.ListUserResp;
import com.cdd.self01.repository.po.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PoDtoConvertor {
    ListUserResp toListUserResp(UserPO userPO);
}
