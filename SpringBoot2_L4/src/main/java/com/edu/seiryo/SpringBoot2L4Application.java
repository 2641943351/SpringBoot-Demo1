package com.edu.seiryo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.edu.**.mapper", "com.baomidou.mybatisplus.core.mapper"})
public class SpringBoot2L4Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2L4Application.class, args);
    }

}
