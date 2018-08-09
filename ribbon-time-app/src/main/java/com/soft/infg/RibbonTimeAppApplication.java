package com.soft.infg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class RibbonTimeAppApplication {

@Autowired
	private RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppApplication.class, args);
	}
	
	@RequestMapping
	public String getTime()
	{
		return restTemplate.getForEntity("http://time-service", String.class).getBody();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate resttemplate()
	{
		
		return new RestTemplate();
	}
}
