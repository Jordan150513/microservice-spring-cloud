package com.qiaodan.itmei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.qiaodan.itmei.*")
@EnableSwagger2
@EnableEurekaClient
public class MicroserviceAccountWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAccountWalletApplication.class, args);
	}
}
