package com.example.gotogradus.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "volume")
    private BigDecimal volume;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "description")
    private String description;

    @Column(name = "alcohol_percent")
    private BigDecimal alcoholPercent;

    @Column(name = "picture_path")
    private String picturePath;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @Column(name = "is_active")
    private boolean isActive;
}
