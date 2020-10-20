package com.study.demo;

import com.study.demo.config.IgnoreUrlConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yizhicheng
 * @ClassName IgnoreUrlConfigTest
 * @Description 白名单测试
 * @Date 2020/10/20 11:18 AM
 **/

@Slf4j
public class IgnoreUrlConfigTest extends BaseTest {

    @Autowired
    private IgnoreUrlConfig ignoreUrlConfig;


    @Test
    public void urls() {
        log.info("urls list ---- {}",ignoreUrlConfig.getUrls().size());
        ignoreUrlConfig.getUrls().forEach(x -> {
            log.info(x);
        });
    }
}
