package com.study.demo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author yizhicheng
 * @ClassName JwtUtils
 * @Description jwt工具类
 * @Date 2020/10/20 10:13 AM
 **/
public class JwtUtils {
    /**
     * 5个小时
     */
    private static int expire = 60*60*5;

    private static String secret = "123456789zxcvbnm.";

    public static String generateToken(Map<String, Object> claims, String subject) {
        Date now = Calendar.getInstance().getTime();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis() + expire * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public static Claims getClaims(String token){
        Claims claims = Jwts
                .parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }



}
