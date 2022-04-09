package com.yang.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.yang.annotation.LoginRequired;
import com.yang.response.ResultCode;
import com.yang.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Auth yangyi
 * @Date 2022-04-09 15:55:57
 */
@Slf4j
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        // 方法注解级拦截器
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(LoginRequired.class)) {
            LoginRequired annotation = method.getAnnotation(LoginRequired.class);
            // 有@LoginRequired注解，需要认证
            if (annotation != null) {

                // 没有token的情况
                if (token == null) {
                    throw new APIException(ResultCode.USER_NOT_LOGIN);   // 没有token
                }

                // 校验token
                boolean verify;
                try {
                    Integer userId = JWT.decode(token).getClaim("userId").asInt();
                    verify = JwtUtil.verify(token, userId);
                } catch (JWTDecodeException j) {
                    throw new APIException(ResultCode.USER_NOT_EXIST);
                }
                if (!verify) {
                    throw new APIException(ResultCode.USER_NOT_LOGIN);
                }
            }
        }
        return true;
    }

}
