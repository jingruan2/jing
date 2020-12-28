package com.jingruan.weighsystem.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

public class PraseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser()
                .setSigningKey("my-123")
                //.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NjMyODU2MTB9.iKtLy0T5ZzvzS2sjgcs5WyuM7cofmnzxzml7wicrTnA")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjMiLCJzdWIiOiLmoqbpmLMiLCJpYXQiOjE1ODIwMDM5MzIsImV4cCI6MTU4MjAwMzk5Miwicm9sZSI6ImFkbWluIn0.vN0pcBVNIixcqp6MsSmGWWVyCc4uOkTpcd8MUDHcn4A")
                .getBody();
        System.out.println("用户id:"+claims.getId());
        System.out.println("用户名:"+claims.getSubject());
        System.out.println("用户时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));System.out.println("过期时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色:"+claims.get("role"));
    }
}
