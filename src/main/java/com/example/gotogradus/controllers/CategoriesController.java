package com.example.gotogradus.controllers;

import com.example.gotogradus.dtos.CategoryResponseDto;
import com.example.gotogradus.dtos.ProductResponseDto;
import com.example.gotogradus.services.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoriesService categoriesService;

    @GetMapping("get-all")
    public List<CategoryResponseDto> getAll() {
        return categoriesService.getAll();
    }
}
