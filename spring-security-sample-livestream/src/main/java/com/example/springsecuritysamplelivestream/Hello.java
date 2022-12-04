package com.example.springsecuritysamplelivestream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/helloAdmin")
    public String sayHelloAdmin() {
        return "HelloAdmin";
    }
}
