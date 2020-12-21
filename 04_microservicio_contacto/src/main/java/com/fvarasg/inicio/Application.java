package com.fvarasg.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fvarasg.inicio.controller.ContactosController;

@ComponentScan(basePackages = {"com.fvarasg.inicio.controller","com.fvarasg.inicio.dao","com.fvarasg.inicio.service","com.fvarasg.inicio"})
@EntityScan(basePackages = {"com.fvarasg.inicio.model"})
@EnableJpaRepositories(basePackages = {"com.fvarasg.inicio.dao"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
