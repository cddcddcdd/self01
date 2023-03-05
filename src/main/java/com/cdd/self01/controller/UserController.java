package com.cdd.self01.controller;

import com.cdd.common.api.ApiResponse;
import com.cdd.common.api.PageResponse;
import com.cdd.self01.dto.user.request.ListUserReq;
import com.cdd.self01.dto.user.response.ListUserResp;
import com.cdd.self01.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ApiResponse<PageResponse<ListUserResp>> list(ListUserReq req) {
        return ApiResponse.ok(userService.listUser(req));
    }

}
