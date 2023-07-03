package com.example.gotogradus.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="order_id")
    int order_id;

    @Column(name="product_id")
    int product_id;
}
