package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategoryIdOrderByIdAsc(int categoryId);
}
