package com.uptoser.spring.cloud.alibaba.dubo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class SpringCloudDubboProviderZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboProviderZookeeperApplication.class, args);
    }
}
