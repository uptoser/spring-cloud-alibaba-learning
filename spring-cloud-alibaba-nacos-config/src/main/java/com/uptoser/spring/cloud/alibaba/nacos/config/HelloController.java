package com.uptoser.spring.cloud.alibaba.nacos.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @NacosValue(value = "${info:Local Hello World}",autoRefreshed = true)
    @Value("${info:Local Hello World}")
    private String info;

    @GetMapping("/config")
    public String get(){
        return info;
    }
}
