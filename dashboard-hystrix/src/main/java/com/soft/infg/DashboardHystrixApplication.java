package com.soft.infg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboardHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardHystrixApplication.class, args);
	}
}
