package com.Ecommerce.user_service.Service;

import com.Ecommerce.user_service.DTOs.LoginDTO;
import com.Ecommerce.user_service.DTOs.UserRequestDTO;
import com.Ecommerce.user_service.DTOs.UserResponseDTO;
import com.Ecommerce.user_service.Entity.Users;
import com.Ecommerce.user_service.Exceptions.EmailIsAlreadyRegistered;
import com.Ecommerce.user_service.Exceptions.UserNameMustBeUniqueException;
import com.Ecommerce.user_service.Exceptions.UserNotFoundException;
import com.Ecommerce.user_service.Mapper.UserDTOMapper;
import com.Ecommerce.user_service.Repository.UserRepo;
import com.Ecommerce.user_service.Util.JWTUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService {

    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder;
    private JWTUtil jwtUtil;
    public UserService(UserRepo userRepo, BCryptPasswordEncoder encoder, JWTUtil jwtUtil){
        this.userRepo = userRepo;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

//    POST /users/register → create a new user
    @Transactional
    public UserResponseDTO registeruser(UserRequestDTO userRequestDTO){
        if(userRepo.existsByEmail(userRequestDTO.getEmail())){
            throw new EmailIsAlreadyRegistered("Email ID already in use Please Try to Login");
        }
        if(userRepo.existsByUsername(userRequestDTO.getUsername())){
            throw new EmailIsAlreadyRegistered("UserName already in use Please Try to a different one");
        }
        Users user = UserDTOMapper.toEntity(userRequestDTO);
        user.setPassword(encoder.encode(userRequestDTO.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        return UserDTOMapper.toDTO(userRepo.save(user));
    }
//    POST /users/login → authenticate & return token (later with JWT)
    public String login(LoginDTO loginDTO){
        return jwtUtil.generateJWTToken(loginDTO.username());
    }
//    GET /users/{id} → get user profile
    public UserResponseDTO getUser(int user_id){
        Users user = userRepo.findById(user_id).orElseThrow(()-> new UserNotFoundException("User Not found"));
        return UserDTOMapper.toDTO(user);
    }

//    PUT /users/{id} → update profile
    @Transactional
    public UserResponseDTO updateUser(Integer user_id,UserRequestDTO userRequestDTO){
        System.out.println("In update");
        Users user = userRepo.findById(user_id).orElseThrow(()->new UserNotFoundException("User Doesn't Exist for this ID"));
        if(userRepo.existsByUsernameAndUserIdNot(userRequestDTO.getUsername(),user_id)){
            throw new UserNameMustBeUniqueException("User Name must be Unique");
        }
        user.setUsername(userRequestDTO.getUsername());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setEmail(userRequestDTO.getEmail());
        if(!encoder.matches(userRequestDTO.getPassword(), user.getPassword())){
            user.setPassword(encoder.encode(userRequestDTO.getPassword()));
        }
        user.setUpdatedAt(LocalDateTime.now());
        return UserDTOMapper.toDTO(userRepo.save(user));
    }
}
