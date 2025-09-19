package com.Ecommerce.order_service.DTOs;

import lombok.Data;

@Data
public class OrderItemRequestDTO {
    private String productId;
    private String quantity;
}
