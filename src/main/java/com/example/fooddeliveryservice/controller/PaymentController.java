package com.example.fooddeliveryservice.controller;

import com.example.fooddeliveryservice.domain.Order;
import com.example.fooddeliveryservice.domain.Payment;
import com.example.fooddeliveryservice.repository.OrderRepository;
import com.example.fooddeliveryservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final OrderRepository orderRepository;

    @Autowired
    public PaymentController(PaymentService paymentService, OrderRepository orderRepository) {
        this.paymentService = paymentService;
        this.orderRepository = orderRepository;
    }

    @PostMapping("/{orderId}")
    public ResponseEntity<?> processPayment(@PathVariable Long orderId, @RequestParam BigDecimal amount) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return ResponseEntity.badRequest().body("Order not found");
        }
        Payment payment = paymentService.processPayment(order, amount);
        return ResponseEntity.ok(payment);
    }

    // Other endpoints related to payment operations
}