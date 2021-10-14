package com.example.e_factura.controller;

import com.example.e_factura.domain.model.User;
import com.example.e_factura.domain.service.UserService;
import com.example.e_factura.resource.UserResource;
import com.example.e_factura.service.communication.AuthenticationRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    // TODO: Authentication Controller
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable){
        Page<User> userPage = userService.getAllUsers(pageable);
        List<UserResource> resources = userPage.getContent().
                stream().map(this::convertToResource).
                collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping
    public UserResource registerUser(@RequestBody AuthenticationRequest request){
        User user = new User().setUsername(request.getUsername()).setPassword(request.getPassword());
        return convertToResource(userService.createUser(user));
    }

    private UserResource convertToResource(User user){
        return mapper.map(user, UserResource.class);
    }
}