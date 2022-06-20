package com.example.demo;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {
    // testowa klasa do tworzenia użytkownika (usera):  robi     insert
    //    into
    //        app_user
    //        (id, password, role, username)
    //    values
    //        (default, ?, ?, ?)

    //wstrzykujemu repozytorium
    private AppUserRepo appUserRepo;

    //wstrzykujemu repozytorium przez konstruktor
    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;

        AppUser appUser = AppUser.builder()
                .username("xxx")
                .password(passwordEncoder.encode("xxx"))
                .role("ROLE_ADMIN")
                .build();
//
//
//                new AppUser();
//        appUser.setUsername("xxx");
//        appUser.setRole("ROLE_ADMIN");
//        appUser.setPassword(passwordEncoder.encode("xxx"));

        //zapis usera do bazy
        appUserRepo.save(appUser);
    }


}
