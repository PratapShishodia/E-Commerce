package com.Ecommerce.product_service.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequestDTO {
    private String productId;
    @NotNull(message = "Product Name Cannot be Null")
    private String productName;
    private String productDesc;
    @NotNull(message = "Product Price Cannot be Null")
    private String productPrice;
    @NotNull(message = "Product Category Cannot be Null")
    private String category;
    private String stock;
    private String created_at;
    private String updated_at;
}
