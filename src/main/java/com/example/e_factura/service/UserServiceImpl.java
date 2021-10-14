package com.example.e_factura.service;

import com.example.e_factura.domain.model.User;
import com.example.e_factura.domain.repository.UserRepository;
import com.example.e_factura.domain.service.UserService;
import com.example.e_factura.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static final List<GrantedAuthority> DEFAULT_AUTHORITIES = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "Username", username));
    }

    @Override
    public User createUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new RuntimeException("There is already another user with same username");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), DEFAULT_AUTHORITIES);
    }

    @Override
    public void InitializeUsers() {
        if(userRepository.findAll().size() <= 0){
            userRepository.save(new User().setUsername("admin123").setPassword(passwordEncoder.encode("12345")));
            System.out.print("User added");
            return;
        }
        System.out.print("There are already a user added");
    }
}
