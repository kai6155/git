package com.example.bootTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/*@MapperScan("com.example.bootTest.mapper1")*/

@MapperScan(basePackages = "com.example.bootTest.controller.indexController")
/*@EnableScheduling*/ //定时任务注解开启
public class BootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootTestApplication.class, args);
	}
}
