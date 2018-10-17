package com.qiaodan.itmei;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
//@EnableHystrix
public class MicroserviceConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerFeignApplication.class, args);
	}
}


