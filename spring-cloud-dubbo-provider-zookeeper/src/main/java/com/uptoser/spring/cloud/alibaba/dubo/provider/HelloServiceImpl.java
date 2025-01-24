package com.uptoser.spring.cloud.alibaba.dubo.provider;

import com.uptoser.spring.cloud.alibaba.api.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

@DubboService
public class HelloServiceImpl implements IHelloService {
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        System.out.printf("The message received is [%s]\n",name);
        return String.format("[%s]：Hello,%s",serviceName,name);
    }
}
