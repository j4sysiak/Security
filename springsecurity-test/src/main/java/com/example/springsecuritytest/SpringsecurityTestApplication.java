package com.example.springsecuritytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableJpaRepositories("com.example.springsecuritytest.repository")
@ComponentScan("com.example.springsecuritytest")
@EntityScan("com.example.springsecuritytest.entity")
public class SpringsecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityTestApplication.class, args);
	}

}
