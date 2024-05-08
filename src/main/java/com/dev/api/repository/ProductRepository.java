package com.dev.api.repository;

import java.util.List;

import com.dev.api.model.Product;

public interface ProductRepository {
    List<Product> findAll();
    Product findByReference(String reference);
    void save(Product product);
    void update(String reference, Product product);
    void delete(String reference);
}
