package com.example.springsecuritytest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(classes = SpringsecurityTestApplicationTests.class)
class SpringsecurityTestApplicationTests {

	//@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}

}
