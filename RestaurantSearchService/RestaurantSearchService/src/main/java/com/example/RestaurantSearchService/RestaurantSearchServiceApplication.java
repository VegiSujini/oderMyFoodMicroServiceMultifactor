package com.example.RestaurantSearchService;

import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@EnableEurekaClient
public class RestaurantSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantSearchServiceApplication.class, args);
	}
    @Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return  new RestTemplate();
	}
}
