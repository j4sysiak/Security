package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/hello")
    public String get() {
        return "hello";
    }

    @RequestMapping("/for-admin")
    public String forAdmin() {
        return "hello-admin";
    }

    @RequestMapping("/for-user")
    public String forUser() {
        return "hello-user";
    }
}
