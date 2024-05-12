package com.dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.api.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
