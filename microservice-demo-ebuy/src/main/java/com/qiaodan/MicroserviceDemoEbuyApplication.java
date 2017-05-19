package com.qiaodan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.qiaodan.*")
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients

public class MicroserviceDemoEbuyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDemoEbuyApplication.class, args);
	}
}
