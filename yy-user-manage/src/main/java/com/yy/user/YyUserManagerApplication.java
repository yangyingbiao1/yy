package com.yy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.yy.user.mapper")
public class YyUserManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YyUserManagerApplication.class, args);
    }

}
