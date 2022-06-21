package com.example.demo.repository;

import com.example.demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository <AppUser, Long> {

    Optional<AppUser> findByUsername(String username);  // Optional - zabezpieczenie przed null dla AppUser
}
