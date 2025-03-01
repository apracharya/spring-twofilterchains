package com.example.twofilterchains.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // using username for jwt
//    Optional<User> findByEmail(String email); // using email to login
}
