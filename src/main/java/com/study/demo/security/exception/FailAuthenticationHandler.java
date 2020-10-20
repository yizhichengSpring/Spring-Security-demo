package com.study.demo.security.exception;


import cn.hutool.json.JSONUtil;
import com.study.demo.util.res.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yizhicheng
 * @ClassName FailAuthenticationHandler
 * @Description 401 未授权
 * @Date 2020/10/20 2:31 PM
 **/
@Slf4j
public class FailAuthenticationHandler extends BaseResponse implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        error(response,JSONUtil.parse(Result.failUnAuthorized()));
    }
}
