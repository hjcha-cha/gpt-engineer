package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.domain.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    // Custom query methods if needed
}