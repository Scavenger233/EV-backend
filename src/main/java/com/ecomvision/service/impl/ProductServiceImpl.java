package com.ecomvision.service.impl;

import com.ecomvision.dto.ProductDTO;
import com.ecomvision.entity.Product;
import com.ecomvision.repository.ProductRepository;
import com.ecomvision.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .rating(product.getRating())
                .supply(product.getSupply())
                .yearlySalesTotal(product.getStat().getYearlySalesTotal())
                .yearlyTotalSoldUnits(product.getStat().getYearlyTotalSoldUnits())
                .build();
    }
}