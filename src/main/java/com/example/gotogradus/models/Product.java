package com.example.gotogradus.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "volume")
    public BigDecimal volume;

    @Column(name = "price")
    public BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "country_id")
    public Country country;

    @Column(name = "description")
    public String description;

    @Column(name = "alcohol_percent")
    public BigDecimal alcoholPercent;

    @Column(name = "picture_path")
    public String picturePath;

    @ManyToOne
    @JoinColumn(name = "category_id")
    public Category categoryId;

    @Column(name = "is_active")
    public boolean isActive;
}
