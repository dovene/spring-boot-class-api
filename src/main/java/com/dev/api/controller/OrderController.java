package com.dev.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.api.model.ProductOrder;
import com.dev.api.service.productorder.ProductOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ProductOrderService orderService;

    @GetMapping
    public List<ProductOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ProductOrder getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ProductOrder createOrder(@RequestBody ProductOrder order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public ProductOrder updateOrder(@PathVariable Long id, @RequestBody ProductOrder order) {
        return orderService.updateOrder(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
