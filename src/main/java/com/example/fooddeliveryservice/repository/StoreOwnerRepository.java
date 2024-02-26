package com.example.fooddeliveryservice.repository;

import com.example.fooddeliveryservice.domain.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOwnerRepository extends JpaRepository<StoreOwner, Long> {
    // Custom query methods if needed
}