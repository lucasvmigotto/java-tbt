package com.java_tbt.api.data.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.java_tbt.api.core.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByUsername(String username);
}
