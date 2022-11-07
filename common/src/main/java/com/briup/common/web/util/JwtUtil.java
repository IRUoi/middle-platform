package com.briup.common.web.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;
import java.util.Map;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/7/2022-11-07-4:06 PM
 * @Description：com.briup.common.web.util
 */
public class JwtUtil {
    /**
     * 过期时间5分钟 token有效时间
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;
    /**
     * jwt 密钥   签名: sh256(头部.载荷,密钥)
     */
    private static final String SECRET = "secret";

    /**
     * 生成签名，五分钟后过期
     * @param userId
     * @param info，Map的value只能存放的值的类型为：Map, List, Boolean, Integer, Long, Double, String and Date
     * @return
     */
    public static String sign(String userId,Map<String,Object> info) {
        try {
            // 签发时间 载荷(注册数据)
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 算法和密钥
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            return JWT.create()
                    // 将 user id 保存到 token 里面
                    .withAudience(userId)
                    // 存放自定义数据
                    .withClaim("info", info)
                    // 五分钟后token过期
                    .withExpiresAt(date)
                    // token 的密钥
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据token获取userId
     * @param token
     * @return
     */
    public static String getUserId(String token) {
        try {
            String userId = JWT.decode(token).getAudience().get(0);
            return userId;
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 根据token获取自定义数据info
     * @param token
     * @return
     */
    public static Map<String,Object> getInfo(String token) {
        try {
            return JWT.decode(token).getClaim("info").asMap();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static boolean checkSign(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    // .withClaim("username", username)
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("token 无效，请重新获取");
        }
    }
}

