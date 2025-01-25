package com.uptoser.spring.cloud.alibaba.dubo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan//Dubbo的扫描注解
@SpringBootApplication
public class SpringCloudDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboProviderApplication.class, args);
    }
}
