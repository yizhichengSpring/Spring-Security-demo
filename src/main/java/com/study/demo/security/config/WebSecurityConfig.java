package com.study.demo.security.config;

import com.study.demo.config.IgnoreUrlConfig;
import com.study.demo.security.exception.FailAuthentication;
import com.study.demo.security.exception.FailForbiddenException;
import com.study.demo.security.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yizhicheng
 * @ClassName WebSecurityConfig
 * @Description WebSecurityConfig 配置类
 * @Date 2020/10/20 10:28 AM
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private IgnoreUrlConfig ignoreUrlConfig;

    /**
     * 数据源 密码加密方式
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


    /**
     * 白名单，认证、授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 白名单
         */
        for (String whiteUrl:ignoreUrlConfig.getUrls()) {
            http.authorizeRequests().antMatchers(whiteUrl).permitAll();
        }
        /**
         * 剩下的所有url需要校验
         */
        http.authorizeRequests().anyRequest().authenticated();
        /**
         * 关闭csrf 和 不使用session
         */
        http.authorizeRequests().and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /**
         * 自定义过滤器
         */
        http.authorizeRequests()
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);

        /**
         * 自定义异常返回值
         */
        http.exceptionHandling()
                .authenticationEntryPoint(new FailAuthentication())
                .accessDeniedHandler(new FailForbiddenException());


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public FailForbiddenException failForbiddenException() {
        return new FailForbiddenException();
    }

    @Bean
    public FailAuthentication failAuthentication() {
        return new FailAuthentication();
    }
}
