package com.eazybytes.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// To access the Eureka Server dashboard, navigate to http://localhost:8070
// Eureka Server acts as a service registry that holds information about all available microservice instances.
// It enables automatic registration of services and simplifies inter-service communication without hardcoding IP addresses or hostnames.
@SpringBootApplication
@EnableEurekaServer // Enable Eureka Server functionality in this Spring Boot application
public class EurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverApplication.class, args);
	}

}
