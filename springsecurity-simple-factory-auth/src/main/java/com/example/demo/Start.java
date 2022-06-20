package com.example.demo;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Start {
    // testowa klasa do trzymania użytkownika (usera)

    //wstrzykujemu repozytorium
    private AppUserRepo appUserRepo;

    //wstrzykujemu repozytorium przez konstruktor
    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;

        AppUser appUser = AppUser.builder()
                .userName("xxx")
                .password(passwordEncoder.encode("xxx"))
                .role("ROLE_ADMIN")
                .build();

        //zapis usera do bazy
        appUserRepo.save(appUser);
    }


}
