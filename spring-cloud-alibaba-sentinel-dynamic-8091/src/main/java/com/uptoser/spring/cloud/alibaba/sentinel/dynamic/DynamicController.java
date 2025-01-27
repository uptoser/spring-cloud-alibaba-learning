package com.uptoser.spring.cloud.alibaba.sentinel.dynamic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicController {

    @GetMapping("/dynamic")
    public String dynamic(){
        return "Hello Dynamic Rule";
    }
}
