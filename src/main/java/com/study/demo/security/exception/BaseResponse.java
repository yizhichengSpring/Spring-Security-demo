package com.study.demo.security.exception;

import cn.hutool.core.util.CharsetUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yizhicheng
 * @ClassName BaseResponse
 * @Description 基础response
 * @Date 2020/10/20 2:34 PM
 **/
public class BaseResponse {

    public void error(HttpServletResponse response,Object json) throws IOException {
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.setHeader(HttpHeaders.CACHE_CONTROL,"no-cache");
        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().println(json);
        response.getWriter().flush();
    }
}
