package com.uptoser.spring.cloud.alibaba.dubo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Nacos 2.2.10-RC1版本新增了gRPC通信方式，需要额外开放9848和9849端口。
 * 如果只映射了8848端口，可能会导致连接失败。
 * 使用Docker时需要映射9848和9849端口‌
 */
@DubboComponentScan//Dubbo的扫描注解
@SpringBootApplication
public class SpringCloudDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboProviderApplication.class, args);
    }
}
