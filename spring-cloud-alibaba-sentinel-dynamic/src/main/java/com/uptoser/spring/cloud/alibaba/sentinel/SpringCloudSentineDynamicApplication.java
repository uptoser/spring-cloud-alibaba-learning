package com.uptoser.spring.cloud.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudSentineDynamicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSentineDynamicApplication.class, args);
		System.out.println("http://localhost:8091/dynamic");
	}

}
