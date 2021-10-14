package com.example.e_factura.controller;

import com.example.e_factura.domain.model.User;
import com.example.e_factura.domain.service.UserService;
import com.example.e_factura.service.communication.AuthenticationRequest;
import com.example.e_factura.service.communication.AuthenticationResponse;
import com.example.e_factura.util.JwtCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtCenter tokenCenter;
    @Autowired
    private UserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody AuthenticationRequest request) throws Exception{
        authenticate(request.getUsername(), request.getPassword());

        final UserDetails userDetails = userService.loadUserByUsername(request.getUsername());
        final User user = userService.getUserByUsername(request.getUsername());
        String token = tokenCenter.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse().setUsername(user.getUsername()).setToken(token).setUserId(user.getId()));
    }

    private void authenticate(String username, String password) throws Exception{
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLE", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }

}
