package com.study.demo.security.exception;

import cn.hutool.json.JSONUtil;
import com.study.demo.util.res.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yizhicheng
 * @ClassName FailForbiddenExceptionHandler
 * @Description 403 拒接访问
 * @Date 2020/10/20 2:25 PM
 **/
public class FailForbiddenExceptionHandler extends BaseResponse implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        error(response,JSONUtil.parse(Result.failForbidden()));
    }
}
