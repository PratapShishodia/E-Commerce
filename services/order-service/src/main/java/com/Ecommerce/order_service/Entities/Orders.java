package com.Ecommerce.order_service.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderID;
    private int userID;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private double totalprice;
    private LocalDateTime createdat;
    private LocalDateTime updatedat;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItemList;
}
