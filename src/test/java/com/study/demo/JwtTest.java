package com.study.demo;

import com.study.demo.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yizhicheng
 * @ClassName JwtTest
 * @Description 单元测试
 * @Date 2020/10/20 10:17 AM
 **/
@SpringBootTest
@RunWith(value = SpringRunner.class)
@Slf4j
public class JwtTest {

    @Test
    public void saveJwt() {
        JwtUtils jwtUtils = new JwtUtils();
        Map<String, Object> map = new HashMap<>();
        String token = jwtUtils.generateToken(map,"易志成");
        log.info("token is ------- {}",token);

    }
}
