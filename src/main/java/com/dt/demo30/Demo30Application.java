package com.dt.demo30;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dt.demo30.mapper")
public class Demo30Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo30Application.class, args);
    }

}
