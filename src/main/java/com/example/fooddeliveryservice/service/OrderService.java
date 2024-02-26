package com.example.fooddeliveryservice.service;

import com.example.fooddeliveryservice.domain.Order;
import com.example.fooddeliveryservice.domain.OrderStatus;
import com.example.fooddeliveryservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order placeOrder(String customerName, String menu) {
        Order order = new Order();
        order.setCustomerName(customerName);
        order.setMenu(menu);
        order.setStatus(OrderStatus.PENDING);
        order.setOrderTime(java.time.LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Transactional
    public boolean cancelOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            if (order.getStatus() == OrderStatus.PENDING) {
                order.setStatus(OrderStatus.CANCELLED);
                orderRepository.save(order);
                return true;
            }
        }
        return false;
    }

    // Other methods related to order operations
}