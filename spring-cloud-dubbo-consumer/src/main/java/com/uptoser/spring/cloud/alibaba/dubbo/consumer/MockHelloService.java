package com.uptoser.spring.cloud.alibaba.dubbo.consumer;

import com.uptoser.spring.cloud.alibaba.api.dubbo.IHelloService;

public class MockHelloService implements IHelloService {
    @Override
    public String sayHello(String s) {
        return "Sorry，服务无法访问，返回降级数据";
    }
}
