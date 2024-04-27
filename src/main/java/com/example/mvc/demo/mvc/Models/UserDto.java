package com.example.mvc.demo.mvc.Models;

import jakarta.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty(message = "The username is required")
    private String name;
    @NotEmpty(message = "The password is required")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
