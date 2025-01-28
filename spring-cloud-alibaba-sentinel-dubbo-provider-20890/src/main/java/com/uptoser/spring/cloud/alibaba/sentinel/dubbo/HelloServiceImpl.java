package com.uptoser.spring.cloud.alibaba.sentinel.dubbo;

import com.uptoser.spring.cloud.alibaba.api.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String str) {
        return "Hello "+str;
    }
}
