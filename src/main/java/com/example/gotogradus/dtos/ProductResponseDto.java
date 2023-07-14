package com.example.gotogradus.dtos;

import com.example.gotogradus.models.Category;
import com.example.gotogradus.models.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private int id;
    private String name;
    private BigDecimal volume;
    private BigDecimal price;
    private int countryId;
    private String countryName;
    private String description;
    private BigDecimal alcoholPercent;
    private String picturePath;
    private int categoryId;
    private String categoryName;
}
