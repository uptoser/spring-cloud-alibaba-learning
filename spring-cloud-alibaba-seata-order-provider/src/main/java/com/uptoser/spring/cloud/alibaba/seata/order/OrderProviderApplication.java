package com.uptoser.spring.cloud.alibaba.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.gupaoedu.springcloud.seata.orderprovider.dal.mappers")
@SpringBootApplication
public class OrderProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProviderApplication.class, args);
	}

}
