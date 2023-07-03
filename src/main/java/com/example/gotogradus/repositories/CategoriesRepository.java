package com.example.gotogradus.repositories;

import com.example.gotogradus.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Category, Integer> {
}
