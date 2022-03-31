package com.zjnu.util;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class GenerateToken {
    private long time = 1000*60*60*24;
    private String signature = "lxh111";
    public String generate(String username,String role){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //添加头
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("username",username)
                .claim("role",role)
                //有效时间
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .setId(UUID.randomUUID().toString())
                //signature
                .signWith(SignatureAlgorithm.HS256,signature)
                //拼接
                .compact();
        System.out.println(jwtToken);


        return jwtToken;
    }
    public String  decode(String token){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        Date expiration = body.getExpiration();
        return String.valueOf(expiration);
    }
}
