package com.x.priceEngine.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "product_name")
    private String productName;


    @Column(name = "cartoon_price", nullable = false)
    private Double cartonPrice;


    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "discount_precentage")
    private Double discountPrecentage = 0.1;

    @Column(name = "discount_margin")
    private Integer minCartoonAmountToDiscount = 3;
}
