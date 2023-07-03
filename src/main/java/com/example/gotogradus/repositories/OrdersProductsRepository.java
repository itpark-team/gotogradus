package com.example.gotogradus.repositories;

import com.example.gotogradus.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersProductsRepository extends JpaRepository<OrderProduct, Integer> {
}
