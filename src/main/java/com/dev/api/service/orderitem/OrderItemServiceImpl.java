package com.dev.api.service.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.api.model.OrderItem;
import com.dev.api.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService{
@Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public List<OrderItem> getAllOrderItems() {
     return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderItem> createOrderItem(List<OrderItem> orderItems) {
        return orderItemRepository.saveAll(orderItems);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        if (orderItemRepository.existsById(id)) {
            orderItem.setId(id);
            return orderItemRepository.save(orderItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    
}