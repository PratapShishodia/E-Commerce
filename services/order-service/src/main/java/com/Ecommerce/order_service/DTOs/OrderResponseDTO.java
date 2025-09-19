package com.Ecommerce.order_service.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {
    private String orderID;
    private String userID;
    private String status;
    private String totalprice;
    private String createdat;
    private String updatedat;
    private List<OrderItemResponseDTO> orderItemList;
}
