package com.Ecommerce.user_service.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotNull(message = "User name cannot be Empty")
    private String username;
    @Email
    @NotNull(message = "Email is Not Valid")
    private String email;
    private String password;
    @NotNull(message = "First name cannot be Empty")
    private String firstName;
    private String lastName;
    private String createdAt;
    private String updatedAt;
}
