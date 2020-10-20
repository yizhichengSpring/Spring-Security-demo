package com.study.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yizhicheng
 * @ClassName IgnoreUrl
 * @Description 白名单
 * @Date 2020/10/20 11:17 AM
 **/
@Component
@Data
@Configuration
@PropertySource(value = {"classpath:/application.yml"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "ignore")
public class IgnoreUrlConfig {

    private List<String> urls;
}
