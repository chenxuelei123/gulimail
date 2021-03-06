package com.atguigu.gulimall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

/*
* 1、开启服务注册发现
* 2、配置nacos注册中心地址
* */
@EnableDiscoveryClient
@SpringBootApplication
/*
* 排除数据库依赖，pom里排除，或者用注解
* @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
* */
public class GulimallGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GulimallGatewayApplication.class, args);
	}

}
