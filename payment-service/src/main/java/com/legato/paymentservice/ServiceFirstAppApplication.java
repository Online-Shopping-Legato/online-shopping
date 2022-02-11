package com.legato.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceFirstAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFirstAppApplication.class, args);
	}

}
