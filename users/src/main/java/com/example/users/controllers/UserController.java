package com.example.users.controllers;

import com.example.users.dto.UserCreationDTO;
import com.example.users.entities.User;
import com.example.users.utilities.UserConverter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final AtomicLong idCounter = new AtomicLong();
    private final List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers(){
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody UserCreationDTO userCreationDTO){
        long newId = idCounter.incrementAndGet();
        User user = UserConverter.convertToEntity(userCreationDTO);
        user.setId(newId);
        users.add(user);
        return user;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        users.removeIf(user -> user.getId() == id);
    }

}
