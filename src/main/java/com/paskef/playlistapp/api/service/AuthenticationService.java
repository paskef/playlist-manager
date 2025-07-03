package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.model.User;
import com.paskef.playlistapp.repository.UserRepository;
import com.paskef.playlistapp.exception.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password)  {
        Optional<User> userOptional = userRepository.findByUsername(username);

        User user = userOptional.orElseThrow(() ->
                new AuthenticationException("Invalid username or password")
        );

        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid username or password");
        }

        return user;
    }


}

