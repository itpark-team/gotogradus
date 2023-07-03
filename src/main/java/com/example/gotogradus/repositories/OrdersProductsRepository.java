package com.example.gotogradus.repositories;

import com.example.gotogradus.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersProductsRepository extends JpaRepository<OrderProduct, Integer> {
}
