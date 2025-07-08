package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.User;
import com.paskef.playlistapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void removeUser(int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User with id " + id + " not found!");
        }
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found!"));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(int id, User updatedUser){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found!"));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());

        return userRepository.save(existingUser);
    }
}
