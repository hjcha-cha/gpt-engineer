package com.example.fooddelivery.front;

import com.example.fooddelivery.front.dto.OrderRequest;
import com.example.fooddelivery.front.dto.OrderResponse;
import com.example.fooddelivery.front.entity.Order;
import com.example.fooddelivery.front.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        // Implement the logic to create an order
        // This is a placeholder for the actual implementation
        Order order = new Order();
        // Set properties on the order from the orderRequest
        order = orderRepository.save(order);
        return new OrderResponse(order.getId(), order.getStatus());
    }

    public OrderResponse getOrderById(Long orderId) {
        // Implement the logic to retrieve an order by ID
        // This is a placeholder for the actual implementation
        Order order = orderRepository.findById(orderId).orElseThrow();
        return new OrderResponse(order.getId(), order.getStatus());
    }

    public void cancelOrder(Long orderId) {
        // Implement the logic to cancel an order
        // This is a placeholder for the actual implementation
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}