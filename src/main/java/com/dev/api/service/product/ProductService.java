package com.dev.api.service.product;

import java.util.List;
import com.dev.api.model.Product;

public interface ProductService {
    List<Product> findAll();
    Product findByReference(String reference);
    Product save(Product product) throws Exception;
    Product update(String reference, Product product) throws Exception;
    void delete(String reference)throws Exception;
}
