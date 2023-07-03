package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
