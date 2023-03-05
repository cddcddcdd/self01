package com.cdd.self01.config;

import com.cdd.common.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: cdd
 * @Date: Created in 2023/3/3
 * @Description:
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse unexpectedException(
            HttpServletRequest request,
            HttpServletResponse response,
            Exception e) {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ApiResponse apiResponse= ApiResponse.fail(e.getMessage());

        log.error("unexpected exception: ", e);
        return apiResponse;
    }

}
