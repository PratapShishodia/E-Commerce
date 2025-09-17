package com.Ecommerce.product_service.DTOs;


import lombok.Data;

@Data
public class ProductResponseDTO {
    private String productId;
    private String productName;
    private String productDesc;
    private String productPrice;
    private String category;
    private String stock;
    private String created_at;
    private String updated_at;
}
