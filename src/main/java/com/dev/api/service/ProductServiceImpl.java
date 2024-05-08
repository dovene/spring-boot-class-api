package com.dev.api.service;

import java.util.List;

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
        return productRepository.findByReference(reference);
    }

    @Override
    public Product save(Product product) throws Exception {
         if (findByReference(product.getReference()) != null){
             throw new Exception("Resource already exists");   
         }
        productRepository.save(product);
        return productRepository.findByReference(product.getReference());
    }

    @Override
    public Product update(String reference, Product product) throws Exception {
        if (productRepository.findByReference(reference) == null){
            throw new Exception("Resource does not exist");  
        }
        productRepository.update(reference, product);
        return productRepository.findByReference(reference);
    }

    @Override
    public void delete(String reference) throws Exception {
        if (productRepository.findByReference(reference) != null){
            productRepository.delete(reference);
        } else {
            throw new Exception("Resource does not exist");    
        }
    }
    
}
