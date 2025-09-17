package com.Ecommerce.product_service.Repository;

import com.Ecommerce.product_service.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    Page<Product> findAllByCategory(String category, Pageable pageable);
}
