package com.example.gotogradus.services;

import com.example.gotogradus.dtos.CategoryResponseDto;
import com.example.gotogradus.dtos.ProductResponseDto;
import com.example.gotogradus.models.Category;
import com.example.gotogradus.models.Product;
import com.example.gotogradus.repositories.CategoriesRepository;
import com.example.gotogradus.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriesService {
    private ModelMapper modelMapper;
    private CategoriesRepository categoriesRepository;

    public List<CategoryResponseDto> getAll() {
        List<Category> categories = categoriesRepository.findAll();

        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryResponseDto.class))
                .collect(Collectors.toList());
    }
}
