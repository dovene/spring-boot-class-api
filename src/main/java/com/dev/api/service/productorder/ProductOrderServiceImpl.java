package com.dev.api.service.productorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.api.model.ProductOrder;
import com.dev.api.repository.ProductOrderRepository;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {
  @Autowired
    private ProductOrderRepository orderRepository;

    @Override
    public List<ProductOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public ProductOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public ProductOrder createOrder(ProductOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public ProductOrder updateOrder(Long id, ProductOrder order) {
        if (orderRepository.existsById(id)) {
            order.setId(id);
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
    
}
