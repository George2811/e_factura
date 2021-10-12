package com.example.e_factura.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveUserResource {
    @NotBlank
    @Size(max = 50)
    private String username;

    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public SaveUserResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveUserResource setPassword(String password) {
        this.password = password;
        return this;
    }
}
