package com.Ecommerce.user_service.Controllers;

import com.Ecommerce.user_service.DTOs.LoginDTO;
import com.Ecommerce.user_service.DTOs.UserRequestDTO;
import com.Ecommerce.user_service.DTOs.UserResponseDTO;
import com.Ecommerce.user_service.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

//    POST /users/register → create a new user
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO requestDTO){
        return new ResponseEntity<>(userService.registeruser(requestDTO), HttpStatus.CREATED);
    }
//    POST /users/login → authenticate & return token (later with JWT)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        return new ResponseEntity<>(userService.login(loginDTO),HttpStatus.ACCEPTED);
    }
//    GET /users/{id} → get user profile
    @GetMapping("/{user_id}")
    public ResponseEntity<UserResponseDTO> getuser(@PathVariable Integer user_id){
        return new ResponseEntity<>(userService.getUser(user_id),HttpStatus.OK);
    }
//    PUT /users/{id} → update profile
    @PutMapping("/{user_id}")
    public ResponseEntity<UserResponseDTO> updateuser(@PathVariable Integer user_id,@Valid @RequestBody UserRequestDTO requestDTO){
        return new ResponseEntity<>(userService.updateUser(user_id,requestDTO),HttpStatus.OK);
    }
}
