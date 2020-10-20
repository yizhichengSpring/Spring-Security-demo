package com.study.demo;

import com.study.demo.security.mapper.UserMapper;
import com.study.demo.security.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author yizhicheng
 * @ClassName UserTest
 * @Description 用户单元测试
 * @Date 2020/10/20 11:00 AM
 **/
@SpringBootTest
@RunWith(value = SpringRunner.class)
@Slf4j
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void list() {
        List<User> users = userMapper.selectList(null);
        log.info("users ---- size {} ",users.size());
        users.stream().forEach(x -> {
            log.info("username {}",x.getUserName());
            log.info("password {}",x.getPassword());
        });
    }
}
