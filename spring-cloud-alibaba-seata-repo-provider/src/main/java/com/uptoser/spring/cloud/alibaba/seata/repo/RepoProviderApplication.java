package com.uptoser.spring.cloud.alibaba.seata.repo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.gupaoedu.springcloud.seata.repoprovider.dal.mappers")
@SpringBootApplication
public class RepoProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoProviderApplication.class, args);
	}

}
