package com.study.demo.security.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.demo.security.mapper.UserMapper;
import com.study.demo.security.pojo.User;
import com.study.demo.security.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yizhicheng
 * @ClassName UserDetailServiceImpl
 * @Description userService实现类
 * @Date 2020/10/20 10:43 AM
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",name);
        User user = userMapper.selectOne(queryWrapper);
        return new UserInfo(user);
    }
}
