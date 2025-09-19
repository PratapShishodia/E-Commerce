package com.Ecommerce.order_service.Service;

import com.Ecommerce.order_service.DTOs.OrderRequestDTO;
import com.Ecommerce.order_service.DTOs.OrderResponseDTO;
import com.Ecommerce.order_service.Entities.OrderStatus;
import com.Ecommerce.order_service.Entities.Orders;
import com.Ecommerce.order_service.Mapper.OrderDTOMapper;
import com.Ecommerce.order_service.Repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

//    POST /orders/{userId} → create new order from user’s cart
    public OrderResponseDTO createOrder(OrderRequestDTO requestDTO){
        Orders order = OrderDTOMapper.toEntity(requestDTO);
        order.setCreatedat(LocalDateTime.now());
        order.setStatus(OrderStatus.PENDING);
        order.setTotalprice(order.getOrderItemList().stream().mapToDouble(item -> item.getProductId()*1000).sum());
        return OrderDTOMapper.toDTO(orderRepo.save(order));
    }
//    GET /orders/{id} → fetch order details
    public OrderResponseDTO fetchOrder(int order_id){
        Orders order = orderRepo.findById(order_id).get();
        return OrderDTOMapper.toDTO(order);
    }
//    GET /orders/user/{userId} → list all orders for a user
    public List<OrderResponseDTO> fetchOrders(int order_id){
        List<Orders> orderlist = orderRepo.findByUserID(order_id);
        return orderlist.stream().map(OrderDTOMapper::toDTO).toList();
    }
//    PUT /orders/{id}/status → update order status (admin/payment trigger)
    public OrderResponseDTO processPayment(int order_id){
        Orders order = orderRepo.findById(order_id).get();
        order.setStatus(OrderStatus.CONFIRMED);
        order.setUpdatedat(LocalDateTime.now());
        return OrderDTOMapper.toDTO(orderRepo.save(order));
    }

}
