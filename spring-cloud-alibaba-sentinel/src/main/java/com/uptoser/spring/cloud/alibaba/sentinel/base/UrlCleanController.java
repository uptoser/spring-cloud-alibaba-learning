package com.uptoser.spring.cloud.alibaba.sentinel.base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Sentinel中HTTP服务的限流默认由Sentinel-Web-Servlet包中的CommonFilter来实现，
 * 从代码中可以看到，这个Filter会把每个不同的URL都作为不同的资源来处理。
 * 在下面这段代码中，提供了一个携带{id}参数的REST风格API，对于每一个不同的{id}，
 * URL也都不一样，所以在默认情况下Sentinel会把所有的URL当作资源来进行流控。
 * 这会导致两个问题：
 * • 限流统计不准确，实际需求是控制clean方法总的QPS，结果统计的是每个URL的QPS。
 * • 导致Sentinel中资源数量过多，默认资源数量的阈值是6000，对于多出的资源规则将不会生效。
 * 针对这个问题可以通过UrlCleaner接口来实现资源清洗
 * 也就是对于/clean/{id}这个URL，我们可以统一归集到/clean/*资源下
 * 可以通过实现UrlCleaner接口，并重写clean方法
 */
@RestController
public class UrlCleanController {

    @GetMapping("/clean/{id}")
    public String dash(@PathVariable("id")int id){
        return "Hello clean";
    }

}
