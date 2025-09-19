package com.Ecommerce.order_service.Mapper;

import com.Ecommerce.order_service.DTOs.OrderItemRequestDTO;
import com.Ecommerce.order_service.DTOs.OrderItemResponseDTO;
import com.Ecommerce.order_service.DTOs.OrderResponseDTO;
import com.Ecommerce.order_service.Entities.OrderItem;

public class OrderItemDTOMapper {
    public static OrderItemResponseDTO toDTO(OrderItem orderItem){
        OrderItemResponseDTO responseDTO = new OrderItemResponseDTO();
        responseDTO.setItemId(String.valueOf(orderItem.getItemId()));
        responseDTO.setProductId(String.valueOf(orderItem.getProductId()));
        responseDTO.setPrice(String.valueOf(orderItem.getPrice()));
        responseDTO.setQuantity(String.valueOf(orderItem.getQuantity()));
//        responseDTO.setOrder(OrderDTOMapper.toDTO(orderItem.getOrder()));
        return responseDTO;
    }

    public static OrderItem toEntity(OrderItemRequestDTO requestDTO){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(Integer.parseInt(requestDTO.getProductId()));
        orderItem.setQuantity(Integer.parseInt(requestDTO.getQuantity()));
        return orderItem;
    }
}
