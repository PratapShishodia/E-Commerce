package com.Ecommerce.user_service.Service;

import com.Ecommerce.user_service.Entity.Users;
import com.Ecommerce.user_service.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepository;

    public CustomUserDetailsService(UserRepo userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Signed Up"));
        return new CustomUserDetails(user);
    }
}
