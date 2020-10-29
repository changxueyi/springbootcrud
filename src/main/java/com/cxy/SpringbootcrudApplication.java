package com.cxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.cxy.dao")
@EnableCaching
public class SpringbootcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootcrudApplication.class, args);
    }

}
