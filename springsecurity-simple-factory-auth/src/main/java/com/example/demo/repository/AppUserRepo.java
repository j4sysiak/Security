package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository <AppUser, Long> {

    Optional<AppUser> findByUsername(String username);  // Optional - zabezpieczenie przed null dla AppUser
}
