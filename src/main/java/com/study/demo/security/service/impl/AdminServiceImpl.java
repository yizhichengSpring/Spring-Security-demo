package com.study.demo.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.demo.jwt.JwtUtils;
import com.study.demo.security.mapper.UserMapper;
import com.study.demo.security.pojo.User;
import com.study.demo.security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author yizhicheng
 * @ClassName AdminServiceImpl
 * @Description AdminService实现类
 * @Date 2020/10/20 10:43 AM
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String userName, String password) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name",userName);
        userQueryWrapper.eq("password",password);
        User user = userMapper.selectOne(userQueryWrapper);
        if (null != user) {
           return JwtUtils.generateToken(new HashMap<>(0),user.getUserName());
        }
        return null;
    }
}
