package com.dev.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.api.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
   
}
