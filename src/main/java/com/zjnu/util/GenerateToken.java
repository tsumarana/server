package com.zjnu.util;

import com.sun.javafx.scene.traversal.Algorithm;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class GenerateToken {
    private long time = 1000*60*60*24;
    private String signature = "lixh";
    public String generate(String id,String username,String role){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //添加头
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //payload
                .claim("id",id)
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
    public String verify(String token){
        JwtParser jwtParser = Jwts.parser();
        if(token == null || token.equals("null")) {
            System.out.println("token 为NULL");
        }else {
            try {
                Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
                Claims body = claimsJws.getBody();
                String username = String.valueOf(body.get("username"));
                long time = body.getExpiration().getTime();
                long nowTime = new Date().getTime();
                if (nowTime - time < 0) {
                    if (username != null) {
                        return username;
                    }
                }
            }catch (Exception e){
                System.out.println("校验出错");
            }
        }
        System.out.println("verify 为空");
        return "";
    }


}
