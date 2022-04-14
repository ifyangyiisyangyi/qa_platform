package com.yang.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @Auth yangyi
 * @Date 2022-04-09 15:55:57
 */
@Slf4j
public class JwtUtil {

    // token一天后过期
//    public static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;
    @Value("${system.expire-time}")
    public static long expire_time;
    // 秘钥
    public static final String SECRET = "ifyangyiisyangyi";

    // 生成token
    public static String sign(Integer userId) {
        // 现在系统时间+一天
        Date date = new Date(System.currentTimeMillis() + expire_time);
        // 加密
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // 附带user信息
        return JWT.create().withClaim("userId", userId)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    // 校验token
    public static boolean verify(String token, Integer userId) {
        try {
            // 加密
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withClaim("userId", userId)
                    .build();
            // 校验token,校验失败时会直接抛出异常
            jwtVerifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("token校验失败 --> " + e.getMessage());
            return false;
        }
    }
}
