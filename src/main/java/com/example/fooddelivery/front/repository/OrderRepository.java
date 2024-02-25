package com.example.fooddelivery.front.repository;

import com.example.fooddelivery.front.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}