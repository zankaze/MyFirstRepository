package com.xa.fourth_p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xa.fourth_p.mapper")
public class FourthPApplication {

    public static void main(String[] args) {
        SpringApplication.run(FourthPApplication.class, args);
    }

}
