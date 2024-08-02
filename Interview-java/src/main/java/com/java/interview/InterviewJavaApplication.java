package com.java.interview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.java.interview.common.mapper")
public class InterviewJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterviewJavaApplication.class, args);
    }

}
