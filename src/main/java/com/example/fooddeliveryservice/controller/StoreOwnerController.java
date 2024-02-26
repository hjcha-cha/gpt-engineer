package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.domain.Order;
import com.example.fooddeliveryservice.domain.OrderStatus;
import com.example.fooddeliveryservice.repository.OrderRepository;
import com.example.fooddeliveryservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store-owner")
public class StoreOwnerController {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    @Autowired
    public StoreOwnerController(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    @PostMapping("/{orderId}/accept")
    public ResponseEntity<?> acceptOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.badRequest().body("Order not found");
        }
        order.setStatus(OrderStatus.ACCEPTED);
        orderRepository.save(order);
        notificationService.sendNotification("Your order has been accepted", order.getCustomerName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/reject")
    public ResponseEntity<?> rejectOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.badRequest().body("Order not found");
        }
        order.setStatus(OrderStatus.REJECTED);
        orderRepository.save(order);
        notificationService.sendNotification("Your order has been rejected", order.getCustomerName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{orderId}/status")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestParam OrderStatus status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.badRequest().body("Order not found");
        }
        order.setStatus(status);
        orderRepository.save(order);
        notificationService.sendNotification("Your order status has been updated to " + status, order.getCustomerName());
        return ResponseEntity.ok().build();
    }

    // Other endpoints related to store owner operations
}