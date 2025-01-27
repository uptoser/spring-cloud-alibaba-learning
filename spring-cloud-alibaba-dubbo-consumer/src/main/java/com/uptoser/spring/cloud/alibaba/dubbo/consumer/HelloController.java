package com.uptoser.spring.cloud.alibaba.dubbo.consumer;

import com.uptoser.spring.cloud.alibaba.api.dubbo.IHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    /**
     * Dubbo提供了一种Mock配置来实现服务降级
     * 其中设置了属性cluster="failfast"，因为默认的容错策略会发起两次重试，等待的时间较长。
     */
    @DubboReference(mock = "com.uptoser.spring.cloud.alibaba.dubbo.consumer.MockHelloService",
            cluster = "failfast")
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello(){
        return iHelloService.sayHello("Mic");
    }
}
