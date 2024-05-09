package com.dev.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.api.exception.ResourceAlreadyExistsException;
import com.dev.api.exception.ResourceNotFoundException;
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
    public Product save(Product product) throws ResourceAlreadyExistsException {
        if (productRepository.findById(product.getReference()).isPresent()) {
            throw new ResourceAlreadyExistsException(String.format("Product reference %s already exists",product.getReference()));
        }
        productRepository.save(product);
        return findByReference(product.getReference());
    }

    @Override
    public Product update(String reference, Product product) throws ResourceNotFoundException {
        if (productRepository.findById(reference).isEmpty()) {
            throw new ResourceAlreadyExistsException(String.format("Resourece reference %s does not exist",product.getReference()));
        }
        productRepository.save(product);
        return findByReference(reference);
    }

    @Override
    public void delete(String reference) throws ResourceAlreadyExistsException {
        if (productRepository.findById(reference).isPresent()) {
            productRepository.deleteById(reference);
        } else {
            throw new ResourceAlreadyExistsException(String.format("Resourece reference %s does not exist",reference));
 
        }
    }
}
