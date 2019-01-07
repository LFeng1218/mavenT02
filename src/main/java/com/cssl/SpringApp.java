package com.cssl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages="com.cssl.dao")
@SpringBootApplication		//SpringBoot核心注解
public class SpringApp {

	public static void main(String[] args) {

		SpringApplication.run(SpringApp.class, args);

	}

}
