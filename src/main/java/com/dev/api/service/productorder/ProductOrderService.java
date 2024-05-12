package com.dev.api.service.productorder;

import java.util.List;

import com.dev.api.model.ProductOrder;

public interface ProductOrderService {
    List<ProductOrder> getAllOrders();
    ProductOrder getOrderById(Long id);
    ProductOrder createOrder(ProductOrder order);
    ProductOrder updateOrder(Long id, ProductOrder order);
    void deleteOrder(Long id);
}
