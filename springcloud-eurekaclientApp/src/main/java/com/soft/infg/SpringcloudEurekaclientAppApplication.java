package com.soft.infg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SpringcloudEurekaclientAppApplication {
@Autowired
	private EurekaClient client;

@Autowired
RestTemplateBuilder resttemplate;
	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaclientAppApplication.class, args);
	}
	
	@RequestMapping("/")
	public String getServiceList()
	{
		RestTemplate template=resttemplate.build();
		InstanceInfo instanceInfo= client.getNextServerFromEureka("client-service", false);
		String baseUrl=instanceInfo.getHomePageUrl();
		ResponseEntity<String> response=template.exchange(baseUrl,HttpMethod.GET,null,String.class);
		
		return response.getBody();
	}
	
}
