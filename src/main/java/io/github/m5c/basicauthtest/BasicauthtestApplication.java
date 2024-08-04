package io.github.m5c.basicauthtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicauthtestApplication {
	/**
	 * Following this tutorial for a minimal basic auth setup with spring boot:
	 * https://sabljakovich.medium.com/minimalistic-basic-auth-configuration-with-spring-boot-security-8a31a5d958d2
	*/
	public static void main(String[] args) {
		SpringApplication.run(BasicauthtestApplication.class, args);
	}

}
