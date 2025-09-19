package com.Ecommerce.order_service.Controller;

import com.Ecommerce.order_service.DTOs.OrderRequestDTO;
import com.Ecommerce.order_service.DTOs.OrderResponseDTO;
import com.Ecommerce.order_service.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

//    POST /orders/{userId} → create new order from user’s cart
    @PostMapping("/{user_id}")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO requestDTO){
        return new ResponseEntity<>(orderService.createOrder(requestDTO), HttpStatus.CREATED);
    }
//    GET /orders/{id} → fetch order details
    @GetMapping("/{order_id}")
    public ResponseEntity<OrderResponseDTO> fetchorder(@PathVariable int order_id){
        return new ResponseEntity<>(orderService.fetchOrder(order_id),HttpStatus.OK);
    }
//    GET /orders/user/{userId} → list all orders for a user
    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<OrderResponseDTO>> fetchorders(@PathVariable int user_id){
        return new ResponseEntity<>(orderService.fetchOrders(user_id),HttpStatus.OK);
    }

//    PUT /orders/{id}/status → update order status (admin/payment trigger)
    @PutMapping("/{order_id}/status")
    public ResponseEntity<OrderResponseDTO> processpayment(@PathVariable int order_id){
        return new ResponseEntity<>(orderService.processPayment(order_id),HttpStatus.ACCEPTED);
    }
}
