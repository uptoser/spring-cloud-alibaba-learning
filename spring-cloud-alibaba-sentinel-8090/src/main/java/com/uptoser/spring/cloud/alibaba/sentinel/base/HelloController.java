package com.uptoser.spring.cloud.alibaba.sentinel.base;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置限流资源有几种情况：
 * ○ Sentinel starter在默认情况下会为所有的HTTP服务提供限流埋点，所以如果只想对HTTP服务进行限流，那么只需要添加依赖即可，不需要修改任何代码。
 * ○ 如果想要对特定的方法进行限流或者降级，则需要通过＠SentinalResouce注解来实现限流资源的定义。
 * ○ 可以通过SphU.entry（）方法来配置资源。
 */
@RestController
public class HelloController {

    @SentinelResource(value = "hello", blockHandler = "blockHandlerHello")
    @GetMapping("/say")
    public String hello() {
        return "hello ,Mic";
    }

    public String blockHandlerHello(BlockException e) {
        return "被限流了";
    }
}
