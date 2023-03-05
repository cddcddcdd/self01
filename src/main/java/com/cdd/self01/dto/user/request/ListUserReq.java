package com.cdd.self01.dto.user.request;

import com.cdd.common.api.PageRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
@Getter
@Setter
@ToString(callSuper = true)
public class ListUserReq extends PageRequest {
    private String name;
}
