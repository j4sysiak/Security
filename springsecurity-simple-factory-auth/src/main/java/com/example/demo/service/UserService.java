package com.example.demo.service;

import com.example.demo.mail.MailService;
import com.example.demo.model.AppUser;
import com.example.demo.model.Token;
import com.example.demo.repository.AppUserRepo;
import com.example.demo.repository.TokenRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    //wstrzykujemy mailService
    private MailService mailService;

    //wstrzykujemy tokenRepo
    private TokenRepo tokenRepo;

    //wstrzykujemy te dwie własności
    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;

    public UserService(AppUserRepo appUserRepo,
                       PasswordEncoder passwordEncoder,
                       TokenRepo tokenRepo,
                       MailService mailService) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
    }

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        appUser.setEnabled(false);
        appUserRepo.save(appUser);
        sendToken(appUser); // wysyła token do usera (na maila)
    }

    private void sendToken(AppUser appUser) {
        //generowanie tokena
        String tokenValue = UUID.randomUUID().toString();
        //zapis tokena w bazie danych
        tokenRepo.save(Token.builder()
                .value(tokenValue)
                .appUser(appUser)
                .build());

        //tworzymy endpoint
        String url = "http://localhost:8080/token?value=" + tokenValue;

        //wysłanie maila do usera
        try {
            mailService.sendMail(appUser.getUsername(), "Potwierdzaj to!", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
