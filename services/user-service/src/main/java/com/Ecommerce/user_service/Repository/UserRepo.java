package com.Ecommerce.user_service.Repository;

import com.Ecommerce.user_service.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsername(String name);
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsernameAndUserIdNot(String email, Integer id);
    boolean existsByUsername(String email);
}
