# Spring-Cloud
Cloud Eureka Server :

spring.application.name=discovery-server
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
server.port=8761
spring.cloud.config.discovery.enabled=true


Cloud Eureka Client :

<dependency><groupId>
org.springframework.cloud</groupId><artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
spring.application.name=service
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

Using SpringCloudEurekaClient in an Application Client:

spring.application.name=client
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
eureka.client.register-with-eureka=false


Config Server :

spring.application.name=configserver
server.port=9999
spring.cloud.config.server.git.uri=https://github.com/rijuvan/spring-config-repository.git
eureka.client.service-url.defaultZone=http://localhost:8761/eureka
spring.cloud.config.discovery.enabled=true

<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

Config Client App :

BootStarap.properties

spring.application.name=config-client-App
spring.cloud.config.discovery.enabled=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientAppApplication {

	@Autowired
	private ConfigClientAppConfiguration properties;
	
	@Value("${some.other.property}")
		private String someOtherProerty;
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientAppApplication.class, args);
	}
	
	@RequestMapping("/")
	public String printConfig()
	{
		
		StringBuilder sb=new StringBuilder();
		sb.append(properties.getProperty());
		sb.append("||");
		sb.append(someOtherProerty);
		return sb.toString();
		
	}
}



Gate Way Service :

@EnableZuulProxy
@EnableDiscoveryClient
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
		</dependency>
		
spring.application.name=gatewayservice
eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka












