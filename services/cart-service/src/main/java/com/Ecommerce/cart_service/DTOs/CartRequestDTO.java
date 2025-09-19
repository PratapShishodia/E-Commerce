package com.Ecommerce.cart_service.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CartRequestDTO {
    private String cartID;
    @NotNull(message = "User Id is Required")
    private String userID;
    private String productID;
    private String quantity;
    private String addedat;
}
