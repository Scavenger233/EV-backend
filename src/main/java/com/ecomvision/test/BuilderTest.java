package com.ecomvision.test;

import com.ecomvision.entity.Product;

public class BuilderTest {
    public static void main(String[] args) {
        Product product = Product.builder()
                .name("Sample Product")
                .description("This is a test product.")
                .price(99.99)
                .category("Test")
                .rating(4.5)
                .supply(100)
                .build();

        System.out.println("✅ Builder worked! Product name: " + product.getName());
    }
}