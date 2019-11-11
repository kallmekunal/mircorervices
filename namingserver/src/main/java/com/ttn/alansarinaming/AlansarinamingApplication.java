package com.ttn.alansarinaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AlansarinamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlansarinamingApplication.class, args);
	}

}
