package com.example.gotogradus.services;

import com.example.gotogradus.dtos.ProductResponseDto;
import com.example.gotogradus.models.Product;
import com.example.gotogradus.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductsService {
    private ModelMapper modelMapper;
    private ProductsRepository productsRepository;

    public List<ProductResponseDto> getByCategoryId(int categoryId) {
        List<Product> products = productsRepository.findAllByCategoryIdOrderByIdAsc(categoryId);

        return products.stream()
                .map(product -> modelMapper.map(product, ProductResponseDto.class))
                .collect(Collectors.toList());
    }
}
