package com.example.e_factura.domain.service;

import com.example.e_factura.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
    User getUserByUsername(String username);
    User createUser(User user);
    void InitializeUsers();
}
