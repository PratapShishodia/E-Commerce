package com.Ecommerce.user_service.Mapper;

import com.Ecommerce.user_service.DTOs.UserRequestDTO;
import com.Ecommerce.user_service.DTOs.UserResponseDTO;
import com.Ecommerce.user_service.Entity.Users;

public class UserDTOMapper {

    public static UserResponseDTO toDTO(Users user){
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUserId(String.valueOf(user.getUserId()));
        responseDTO.setEmail(user.getEmail());
        responseDTO.setUsername(user.getUsername());
        responseDTO.setFirstName(user.getFirstName());
        responseDTO.setLastName(user.getLastName());
        responseDTO.setCreatedAt(String.valueOf(user.getCreatedAt()));
        responseDTO.setUpdatedAt(String.valueOf(user.getUpdatedAt()));
        return responseDTO;
    }

    public static Users toEntity(UserRequestDTO requestDTO){
        Users user = new Users();
        user.setEmail(requestDTO.getEmail());
        user.setFirstName(requestDTO.getFirstName());
        user.setLastName(requestDTO.getLastName());
        user.setUsername(requestDTO.getUsername());
        return user;
    }


}
