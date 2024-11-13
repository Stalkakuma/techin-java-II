package com.example.users.controllers;

import com.example.users.dto.UserCreationDTO;
import com.example.users.entities.User;
import com.example.users.services.UserService;
import com.example.users.utilities.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody UserCreationDTO userCreationDTO){
        return userService.addUser(userCreationDTO);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
