package com.yang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auth yangyi
 * @Date 2022-04-08 19:47:46
 * 在需要登录验证的Controller的方法上使用此注解
 */
@Target({ElementType.METHOD}) // 可用在方法上
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
public @interface LoginRequired {
}
