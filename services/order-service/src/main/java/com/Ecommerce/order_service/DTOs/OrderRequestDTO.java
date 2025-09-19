package com.Ecommerce.order_service.DTOs;

import lombok.Data;

import java.util.List;
@Data
public class OrderRequestDTO {
    private String userID;
    private List<OrderItemRequestDTO> orderItemList;
}
