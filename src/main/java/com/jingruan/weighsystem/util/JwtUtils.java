package com.jingruan.weighsystem.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
//@ConfigurationProperties(prefix = "jwt2")
public class JwtUtils {
    private String secret ="f4e2e52034348f86b67cde581c0f9eb5";
    private long shorttime = 3600L;
    private long longtime = 3600*24*7L;
    private String header;
    /**
     * 生成jwt tokenliu
     */
    public String getshort(long userId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime()+shorttime*1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public String getlong(long userId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime()+longtime*1000);
        return Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(userId+"")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    // 获取jwt的信息
    public Claims getClaimByToken(String token) {
        try{
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            System.out.println("s"+e);
            return null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
