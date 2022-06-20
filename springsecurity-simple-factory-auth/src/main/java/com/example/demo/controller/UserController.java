package com.example.demo.controller;

import com.example.demo.model.AppUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller  // mapuje bezpośrednio do plików, czyli hello.html,  hello-admin.html,  hello-user.html
// @RestController    mapuje bezpośrednio do typu zwracanego np:  String  - mapuje np do Stringa hello
public class UserController {

    @RequestMapping("/hello")
    @ResponseBody  // ta anotacja umożliwia zwrócenie String "hello", pomimo tego , że mamy adnotację @Controller  na klasie, co by sugerowało raczej mapping na hello.html
    public String hello() {
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

    @RequestMapping("/sign-up")
    public String signup(Model model) {
        model.addAttribute("user", new AppUser());
        return "sign-up";
    }


    @PostMapping("/register")
    public String register(AppUser appUser) {
        System.out.println(appUser);
        return "sign-up";
    }

}
