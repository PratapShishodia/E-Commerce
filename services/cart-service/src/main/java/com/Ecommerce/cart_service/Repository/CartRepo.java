package com.Ecommerce.cart_service.Repository;

import com.Ecommerce.cart_service.Entity.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    boolean existsByUserIDAndProductID(String userid, String productid);

    Page<Cart> findByUserID(String userid, Pageable pageable);
    List<Cart> findByUserID(String userid);
    Cart findByUserIDAndProductID(String userid, String productid);
}
