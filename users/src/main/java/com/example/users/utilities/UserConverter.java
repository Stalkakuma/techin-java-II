package com.example.users.utilities;

import com.example.users.dto.UserCreationDTO;
import com.example.users.entities.User;

import java.util.UUID;

public class UserConverter {
    public static User convertToEntity(UserCreationDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());

        return user;
    }
}
