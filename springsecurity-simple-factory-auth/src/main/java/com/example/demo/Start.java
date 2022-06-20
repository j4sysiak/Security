package com.example.demo;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepo;

public class Start {
    // testowa klasa do trzymania użytkownika (usera)

    //wstrzykujemu repozytorium
    private AppUserRepo appUserRepo;

    //wstrzykujemu repozytorium przez konstruktor
    public Start(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;

        AppUser appUser = AppUser.builder()
                .userName("xxx")
                .password("xxx")
                .role("Admin")
                .build();
    }


}
