package com.jingruan.weighsystem.util;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class CreateJwt {
    public static String getToken(String username,Date time1,String password){
        JwtBuilder jwtBuilder =  Jwts.builder()
                .setId("1")
                .setSubject(username)
                .setIssuedAt(time1)
                .signWith(SignatureAlgorithm.HS256,"my-123")
                .setExpiration(new Date(new Date().getTime()+60000))
                .claim("password",password);
        return jwtBuilder.compact();
    }
    public static void main(String[] args) {
        //Jwts.builder()生成
        //Jwts.parser()验证
        JwtBuilder jwtBuilder =  Jwts.builder()
                .setId("123")
                .setSubject("梦阳")    //用户名
                .setIssuedAt(new Date())//登录时间
                .signWith(SignatureAlgorithm.HS256, "my-123").setExpiration(new Date(new Date().getTime()+60000))//设置过期时间
                .claim("role","admin"); //自定义属性
        //前三个为载荷playload 最后一个为头部 header
        System.out.println(jwtBuilder.compact());

    }
}
