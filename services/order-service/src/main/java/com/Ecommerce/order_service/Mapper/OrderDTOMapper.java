package com.Ecommerce.order_service.Mapper;

import com.Ecommerce.order_service.DTOs.OrderRequestDTO;
import com.Ecommerce.order_service.DTOs.OrderResponseDTO;
import com.Ecommerce.order_service.Entities.Orders;

public class OrderDTOMapper {
    public static OrderResponseDTO toDTO(Orders order){
        OrderResponseDTO responseDTO = new OrderResponseDTO();
        responseDTO.setOrderID(String.valueOf(order.getOrderID()));
        responseDTO.setUserID(String.valueOf(order.getUserID()));
        responseDTO.setStatus(String.valueOf(order.getStatus()));
        responseDTO.setTotalprice(String.valueOf(order.getTotalprice()));
        responseDTO.setCreatedat(String.valueOf(order.getCreatedat()));
        responseDTO.setUpdatedat(String.valueOf(order.getUpdatedat()));
        responseDTO.setOrderItemList(order.getOrderItemList().stream().map(OrderItemDTOMapper::toDTO).toList());
        return responseDTO;
    }

    public static Orders toEntity(OrderRequestDTO requestDTO){
        Orders order = new Orders();
        order.setUserID(Integer.parseInt(requestDTO.getUserID()));
        order.setOrderItemList(requestDTO.getOrderItemList().stream().map(OrderItemDTOMapper::toEntity).toList());
        return order;
    }
}
