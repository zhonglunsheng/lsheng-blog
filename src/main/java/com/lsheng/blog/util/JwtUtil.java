package com.lsheng.blog.util;

/**
 * @author zhonglunsheng
 * @Description
 * @create 2020-08-02 22:29
 */
import com.lsheng.blog.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtil {


    public static final String SUBJECT = "lipop";

    /**
     * 秘钥
     */
    public static final String APPSECRET = "blog";

    /**
     * 过期时间，毫秒，30分钟
     */
    public static final long EXPIRE = 1000 * 60 * 30;


    /**
     * 生成jwt token
     *
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user) {

        if (user == null || StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return null;
        }

        return Jwts.builder().setSubject(SUBJECT)
                .claim("username", user.getUserName())
                .claim("password", user.getPassword())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
    }


    /**
     * 校验jwt token
     *
     * @param token
     * @return
     */
    public static User checkJWT(String token) {
        User user = null;
        Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
        // 校验token是否过期
        boolean timeFlag = claims.getExpiration().before(new Date());
        if (!timeFlag) {
            String userName = claims.get("username", String.class);
            String password = claims.get("password", String.class);
            if (StringUtils.isNoneBlank(userName) && StringUtils.isNoneBlank(password)) {
                user = new User();
                user.setPassword(password);
                user.setUserName(userName);
            }
        }
        return user;
    }


    public static void main(String[] args){
        User user = new User();
        user.setId(1);
        user.setUserName("admin");
        user.setPassword("admin");
        String token = geneJsonWebToken(user);
        System.out.println(token);
    }
}