package com.Ecommerce.order_service.DTOs;

import java.util.List;

public class OrderResponseDTO {
    private String id;
    private String userId;
    private String status;
    private String totalAmount;
    private String createdAt;
    private String updatedAt;
    private List<OrderItemResponseDTO> items;
}
