package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.domain.Order;
import com.example.fooddeliveryservice.domain.Payment;
import com.example.fooddeliveryservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(Order order, BigDecimal amount) {
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        return paymentRepository.save(payment);
    }

    // Other methods related to payment operations
}