package com.dev.api.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dev.api.model.Product;

@Repository
public class ProductRepositoryInMemoryImpl {

    private ArrayList<Product> products = new ArrayList<>(Arrays.asList(new Product("P1", "bread", 12.0),
            new Product("P2", "sugar", 2.5)));

    public List<Product> findAll() {
        return products;
    }

    public Product findByReference(String reference) {
        Optional<Product> studentOptional = products.stream()
                .filter(product -> reference.equals(product.getReference()))
                .findFirst();
        return studentOptional.isPresent()?  studentOptional.get() : null;
    }

    public void save(Product product) {
        products.add(product);
    }

    public void update(String reference, Product parameterProduct) {
        products.forEach(product -> {
            if (reference.equals(product.getReference())) {
                product.setDesignation(parameterProduct.getDesignation());
                product.setPrice(parameterProduct.getPrice());
            }
        });
    }

    public void delete(String reference) {
        products.removeIf(product -> product.getReference().equals(reference));
    }

}
