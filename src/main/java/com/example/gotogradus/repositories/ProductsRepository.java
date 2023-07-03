package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {
}
