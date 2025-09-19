package com.Ecommerce.order_service.Repository;

import com.Ecommerce.order_service.Entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
    List<Orders> findByUserID(int order_id);
}
