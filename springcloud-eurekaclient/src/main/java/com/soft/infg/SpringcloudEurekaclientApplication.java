package com.soft.infg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudEurekaclientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringcloudEurekaclientApplication.class).web(true).run(args);
	}
}
