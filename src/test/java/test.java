import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.*;
import org.junit.Test;

import javax.print.DocFlavor;
import java.util.Date;
import java.util.UUID;

public class test {

    @Test
    public void test1(){
        String auth1 = "{'/message/selectMessage': true,'/friend/selectList':'true','/message/addMessage':'true','/goods/addGoods':'true'}";
        JSONObject jsonObject = JSON.parseObject(auth1);
        String url = "/message/selectMessage";
        if(jsonObject.get(url) != null){
            Boolean  flag = (Boolean) jsonObject.get(url);
            System.out.println(flag);
            if(flag){
                System.out.println("1111");
            }
        }else {
            System.out.println("不存在");
        }


//        if(flag){
//            System.out.println("为真");
//        }
        System.out.println(jsonObject.get(url));
        System.out.println(jsonObject);
    }
    private long time = 1000*60*60*24;
    private String signature = "lxh111";
    @Test
    public void generate(){
        String id = "111";
        String username = "a";
        String role = "0";
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
    }
@Test
    public void  decode(){
         String token ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjExMSIsInVzZXJuYW1lIjoiYSIsInJvbGUiOiIwIiwiZXhwIjoxNjQ4Nzg0MzAyLCJqdGkiOiI4MTA2MTg1ZC1kNzFkLTQyYmQtYTlmMi04MGI1MjIyZGViMmQifQ.ZHKywXHJC7uMnBrpbxXAvb4CUz0R-Msc6r1u2ciUDNo";
//    String token = "";
    if(token!=null&&token!="") {
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        System.out.println(body.get("username"));
        Date expiration = body.getExpiration();
        long time1 = expiration.getTime();
        long nowTime = new Date().getTime();
        System.out.println(time1 - nowTime);
        System.out.println(time);
        System.out.println(expiration.getTime());
    }
    }
    @Test
    public void test(){
        String token =null;
        System.out.println(token);
        if(token == null){
            System.out.println("fule");
        }
    }

}
