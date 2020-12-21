package com.fvarasg.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroservicioServidorEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioServidorEurekaApplication.class, args);
	}

}
