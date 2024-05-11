package com.dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

