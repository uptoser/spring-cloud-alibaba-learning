package com.uptoser.spring.cloud.alibaba.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboConsumerApplication.class, args);
        System.out.println("http://localhost:8080/say");
    }
}
