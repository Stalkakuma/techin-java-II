package com.example.users.dto;


import lombok.Data;

@Data
public class UserCreationDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
}
