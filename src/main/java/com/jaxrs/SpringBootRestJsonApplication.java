package com.jaxrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.jaxrs.service,com.jaxrs.entity,com.jaxrs.controller"})
public class SpringBootRestJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestJsonApplication.class, args);
	}

}
