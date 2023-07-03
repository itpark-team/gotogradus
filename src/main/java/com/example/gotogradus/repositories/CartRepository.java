package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
