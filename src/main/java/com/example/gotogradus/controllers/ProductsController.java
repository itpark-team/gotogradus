package com.example.gotogradus.controllers;

import com.example.gotogradus.dtos.ProductResponseDto;
import com.example.gotogradus.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductsController {

    private ProductsService productsService;

    @GetMapping("get-all")
    public List<ProductResponseDto> getAll() {
        return productsService.getAll();
    }

    @GetMapping("get-by-category-id/{categoryId}")
    public List<ProductResponseDto> getAll(@PathVariable int categoryId) {
        return productsService.getByCategoryId(categoryId);
    }
}
