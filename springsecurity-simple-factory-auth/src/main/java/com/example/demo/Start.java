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

        AppUser appUserAdmin = AppUser.builder()
                .username("aaa")
                .password(passwordEncoder.encode("aaa"))
                .role("ROLE_ADMIN")
                .isEnabled(true)
                .build();

        AppUser appUserUser = AppUser.builder()
                .username("uuu")
                .password(passwordEncoder.encode("uuu"))
                .role("ROLE_USER")
                .isEnabled(true)
                .build();

        //zapis usera do bazy
        appUserRepo.save(appUserAdmin);
        appUserRepo.save(appUserUser);
    }
}
