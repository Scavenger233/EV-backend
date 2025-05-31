package com.ecomvision.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private double rating;
    private int supply;

    private int yearlySalesTotal;
    private int yearlyTotalSoldUnits;
}