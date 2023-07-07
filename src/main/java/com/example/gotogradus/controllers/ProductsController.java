package com.example.gotogradus.controllers;

import com.example.gotogradus.dtos.ProductResponseDto;
import com.example.gotogradus.services.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
@CrossOrigin
public class ProductsController {

    private ProductsService productsService;

    @GetMapping("get-by-category-id/{categoryId}")
    public List<ProductResponseDto> getAll(@PathVariable int categoryId) {
        return productsService.getByCategoryId(categoryId);
    }
}
