package com.ecomvision.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private Long userId;
    private Double cost;
    private List<String> productIds;
    private String createdAt;
}