package com.Ecommerce.user_service.DTOs;

import lombok.Data;

@Data
public class UserResponseDTO {
    private String userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String createdAt;
    private String updatedAt;
}
