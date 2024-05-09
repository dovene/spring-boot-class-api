package com.dev.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.api.model.Product;
import com.dev.api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByReference(String reference) {
        Optional<Product> optionalProduct = productRepository.findById(reference);
        return optionalProduct.isPresent() ? optionalProduct.get() : null;
    }

    @Override
    public Product save(Product product) throws Exception {
        if (productRepository.findById(product.getReference()).isPresent()) {
            throw new Exception("Resource already exists");
        }
        productRepository.save(product);
        return findByReference(product.getReference());
    }

    @Override
    public Product update(String reference, Product product) throws Exception {
        if (productRepository.findById(reference).isEmpty()) {
            throw new Exception("Resource does not exist");
        }
        productRepository.save(product);
        return findByReference(reference);
    }

    @Override
    public void delete(String reference) throws Exception {
        if (productRepository.findById(reference).isPresent()) {
            productRepository.deleteById(reference);
        } else {
            throw new Exception("Resource does not exist");
        }
    }
}
