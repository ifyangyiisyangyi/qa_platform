package com.yang.config;

import com.yang.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Auth yangyi
 * @Date 2022-04-08 20:24:10
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
        registry.addInterceptor(authorizationInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override   // 处理跨域
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") //设置允许跨域请求的域名
                .allowedMethods("GET", "POST", "HEAD", "PUT", "DELETE", "OPTIONS") //设置允许的方法
                .allowCredentials(true) //是否允许证书
                .maxAge(3600) //配置客户端缓存预检请求的响应时间，单位是秒
                .allowedHeaders("*");
    }
}
