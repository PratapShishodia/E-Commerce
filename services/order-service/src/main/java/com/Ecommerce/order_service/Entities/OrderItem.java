package com.Ecommerce.order_service.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private int productId;
    private int quantity;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;
}
