package com.redhat.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringRestPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestPocApplication.class, args);
	}

}
