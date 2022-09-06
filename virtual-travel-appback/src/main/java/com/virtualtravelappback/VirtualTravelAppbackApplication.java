package com.virtualtravelappback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VirtualTravelAppbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualTravelAppbackApplication.class, args);
	}

}
