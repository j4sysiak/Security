package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@Controller  // mapuje bezpośrednio do plików, czyli hello.html,  hello-admin.html,  hello-user.html
// @RestController    mapuje bezpośrednio do typu zwracanego np:  String  - mapuje np do Stringa hello
public class UserController {

    //dzięi temu wstrzyknięciu mamy odseparowaną logikę do tworzenia usera
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping("/hello")
//    @ResponseBody  // ta anotacja umożliwia zwrócenie String "hello", pomimo tego , że mamy adnotację @Controller  na klasie, co by sugerowało raczej mapping na hello.html
//    public String hello() {
//        return "hello";
//    }

    @RequestMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());

        final Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("authorities", authorities);

        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        model.addAttribute("details", details);
        return "hello";
    }


//    @RequestMapping("/for-admin")
//    public String forAdmin() {
//        return "hello-admin";
//    }
//
//    @RequestMapping("/for-user")
//    public String forUser() {
//        return "hello-user";
//    }
//

    @RequestMapping("/sign-up")
    public String signup(Model model) {
        model.addAttribute("user", new AppUser());
        return "sign-up";
    }


    @PostMapping("/register")
    public String register(AppUser appUser) {
        userService.addUser(appUser);
        System.out.println(appUser);
        return "sign-up";
    }

}
