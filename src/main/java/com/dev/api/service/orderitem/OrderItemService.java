package com.dev.api.service.orderitem;

import java.util.List;

import com.dev.api.model.OrderItem;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem getOrderItemById(Long id);
    List<OrderItem> createOrderItem(List<OrderItem> orderItems);
    OrderItem updateOrderItem(Long id, OrderItem orderItem);
    void deleteOrderItem(Long id);
}
