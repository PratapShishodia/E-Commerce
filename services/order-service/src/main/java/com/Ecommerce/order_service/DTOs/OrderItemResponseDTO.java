package com.Ecommerce.order_service.DTOs;

import lombok.Data;

@Data
public class OrderItemResponseDTO {
    private String itemId;
    private String productId;
    private String quantity;
    private String price;
//    private OrderResponseDTO order;
}
