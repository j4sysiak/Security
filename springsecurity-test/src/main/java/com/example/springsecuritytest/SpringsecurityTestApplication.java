package com.example.springsecuritytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableJpaRepositories("com.example.springsecuritytest.repository")
@ComponentScan("com.example.springsecuritytest")
@EntityScan("com.example.springsecuritytest.entity")
public class SpringsecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityTestApplication.class, args);
	}

}
