package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.mapper")
public class QaPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(QaPlatformApplication.class, args);
    }
}
