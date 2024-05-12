package com.dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.api.model.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
   
}
