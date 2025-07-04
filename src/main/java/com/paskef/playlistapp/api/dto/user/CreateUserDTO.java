package com.paskef.playlistapp.api.dto.user;

import jakarta.validation.constraints.*;

public class CreateUserDTO {
    @NotBlank(message = "Username can't be blank")
    private String username;

    @Email(message = "Invalid e-mail")
    @NotBlank(message = "Email can't be blank")
    private String email;

    @NotBlank(message = "Password can't be blank")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain at least one upper case letter and one special char")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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
