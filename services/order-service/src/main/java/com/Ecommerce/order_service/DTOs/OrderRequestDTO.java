package com.Ecommerce.order_service.DTOs;
import java.util.List;

public class OrderRequestDTO {
    private String userId;
    private List<OrderItemRequestDTO> orderItems;
}
