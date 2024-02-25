package com.example.fooddelivery.front.dto;

import com.example.fooddelivery.front.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private OrderStatus status;
}