package com.uptoser.spring.cloud.alibaba.dubbo.consumer;

import com.uptoser.spring.cloud.alibaba.api.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @DubboReference(mock = "com.uptoser.spring.cloud.alibaba.dubbo.consumer.MockHelloService",
            cluster = "failfast")
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello(){
        return iHelloService.sayHello("Mic");
    }
}
