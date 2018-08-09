package com.soft.infg.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.netty.util.internal.ThreadLocalRandom;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class WeatherServiceApplication {

	private String weather[] = { "Suunny", "Cloudy", "Rainy", "Windy" };

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@RequestMapping("/weather")
	public String getWeather() {

		int rand = ThreadLocalRandom.current().nextInt(0, 4);
		return weather[rand];

	}
}
