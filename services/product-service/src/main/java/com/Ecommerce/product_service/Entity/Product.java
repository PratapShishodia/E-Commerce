package com.Ecommerce.product_service.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String productDesc;
    private double productPrice;
    private String category;
    private Integer stock;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
