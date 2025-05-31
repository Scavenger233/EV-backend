package com.ecomvision.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AffiliateStatDTO {
    private Long id;
    private Long userId; // affiliate's user id
    private List<String> transactionIds; // list of transaction IDs generated via affiliate link
}