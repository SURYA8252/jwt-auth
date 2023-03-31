package com.jwtauth3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JwtAuth3Application {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuth3Application.class, args);
	}

}
