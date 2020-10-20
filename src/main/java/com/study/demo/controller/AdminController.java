package com.study.demo.controller;

import com.study.demo.security.service.AdminService;
import com.study.demo.util.res.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yizhicheng
 * @ClassName AdminController
 * @Description 测试controller
 * @Date 2020/10/20 11:32 AM
 **/
@Api(value = "admin",tags = "提供的demo接口")
@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ApiOperation("登录")
    @GetMapping("/login")
    public Result login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password) {
        String token = adminService.login(userName,password);
        return Result.success(token);
    }

    @ApiOperation("白名单接口")
    @GetMapping("/noauth")
    public Result noauth() {
        log.info("我是白名单方法，header里没有 Authorization 也可以...");
        return Result.success();
    }

    @ApiOperation("需要携带token的接口")
    @GetMapping("/auth")
    public Result auth () {
        log.info("auth 方法开始执行。。。。");
        return Result.success();
    }

}
