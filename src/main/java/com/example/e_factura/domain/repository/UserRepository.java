package com.example.e_factura.domain.repository;

import com.example.e_factura.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userId);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
