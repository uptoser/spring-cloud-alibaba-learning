package com.uptoser.spring.cloud.alibaba.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSentinelApplication.class, args);
		System.out.println("http://localhost:8090/say");
		System.out.println("http://localhost:8090/dash");
		System.out.println("http://localhost:8090/clean/1");
	}

}
