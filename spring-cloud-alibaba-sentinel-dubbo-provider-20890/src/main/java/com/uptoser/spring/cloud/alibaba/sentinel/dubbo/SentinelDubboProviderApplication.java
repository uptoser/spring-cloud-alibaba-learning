package com.uptoser.spring.cloud.alibaba.sentinel.dubbo;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * spring-cloud-starter-alibaba-sentinel目前无法支持Dubbo服务的限流，
 * 所以针对Dubbo服务的限流只能使用sentinel-apache-dubbo-adapter。
 * 这个适配组件并没有自动接入Sentinel Dashboard，需要通过以下步骤来进行接入。
 * • 引入sentinel-transport-simple-http依赖，这个依赖可以上报应用相关信息到控制台。
 * • 添加启动参数。
 * 参数配置说明如下。https://github.com/alibaba/Sentinel/wiki/%E5%90%AF%E5%8A%A8%E9%85%8D%E7%BD%AE%E9%A1%B9
 * ○-Djava.net.preferIPv4Stack：表示只支持IPv4。| -Djava.net.preferIPv4Stack=true
 * ○-Dcsp.sentinel.api.port：客户端的port，用于上报应用的信息。| -Dcsp.sentinel.api.port=8719
 * ○-Dcsp.sentinel.dashboard.server：Sentinel Dashboard地址。| -Dcsp.sentinel.dashboard.server=192.168.3.200:8858
 * ○-Dproject.name：应用名称，会在Sentinel Dashboard右侧展示。|-Dproject.name=spring-cloud-sentinel-dubbo-provider
 *
 * -Djava.net.preferIPv4Stack=true -Dcsp.sentinel.dashboard.server=192.168.3.200:8858 -Dproject.name=spring-cloud-sentinel-dubbo-provider
 */
@SpringBootApplication
public class SentinelDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentinelDubboProviderApplication.class, args);
	}


}
