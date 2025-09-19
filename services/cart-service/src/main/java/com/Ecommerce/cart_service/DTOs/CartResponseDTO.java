package com.Ecommerce.cart_service.DTOs;

import lombok.Data;

@Data
public class CartResponseDTO {
    private String cartID;
    private String userID;
    private String productID;
    private String quantity;
    private String addedat;
}
