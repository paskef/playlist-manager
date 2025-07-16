package com.paskef.playlistapp.api.dto.user;

import jakarta.validation.constraints.*;

public class LoginUserDTO {

    @Email(message = "Invalid email!")
    @NotBlank(message = "Email can't be blank!")
    private String email;

    @NotBlank(message = "Password can't be blank!")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
