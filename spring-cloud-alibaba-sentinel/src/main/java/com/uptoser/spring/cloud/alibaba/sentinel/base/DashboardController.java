package com.uptoser.spring.cloud.alibaba.sentinel.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sentinel Dashboard
 */
@RestController
public class DashboardController {

    /**
     * 由于没有配置流控规则，所以不存在限流行为。
     * 访问http://192.168.3.200:8858/ 进入Sentinel Dashboard，来实现流控规则的配置
     * 访问“簇点链路”，针对/dash这个资源名称单击“流控”按钮设置流控规则
     * 当QPS超过1时，就可以看到限流的效果，并获得如下输出：Blocked by Sentinel (flow limiting)
     */
    @GetMapping("/dash")
    public String dash(){
        return "Hello Dash";
    }
}
