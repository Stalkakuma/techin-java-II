package com.example.users.services;

import com.example.users.dto.UserCreationDTO;
import com.example.users.entities.User;
import com.example.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(UserCreationDTO userCreationDTO) {
        User user = new User();
        user.setFirstName(userCreationDTO.getFirstName());
        user.setLastName(userCreationDTO.getLastName());
        user.setEmail(userCreationDTO.getEmail());
        user.setUsername(userCreationDTO.getUsername());
        userRepository.save(user);
        return user;
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public void updateUser(Long id, UserCreationDTO userCreationDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(userCreationDTO.getFirstName());
        user.setLastName(userCreationDTO.getLastName());
        user.setEmail(userCreationDTO.getEmail());
        user.setUsername(userCreationDTO.getUsername());
        userRepository.save(user);

    }

}

