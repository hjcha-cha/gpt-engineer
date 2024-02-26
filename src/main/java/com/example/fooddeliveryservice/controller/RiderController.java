package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.domain.Order;
import com.example.fooddeliveryservice.domain.OrderStatus;
import com.example.fooddeliveryservice.repository.OrderRepository;
import com.example.fooddeliveryservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riders")
public class RiderController {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    @Autowired
    public RiderController(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    @PostMapping("/{orderId}/pick")
    public ResponseEntity<?> pickOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.badRequest().body("Order not found");
        }
        order.setStatus(OrderStatus.PICKED_UP);
        orderRepository.save(order);
        notificationService.sendNotification("Your order has been picked up by the rider", order.getCustomerName());
        return ResponseEntity.ok().build();
    }

    // Other endpoints related to rider operations
}