package com.cdd.self01.dto.user.response;

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
@ToString
public class ListUserResp {

    private Integer id;
    private String name;
    private Integer age;
    private String email;

}
