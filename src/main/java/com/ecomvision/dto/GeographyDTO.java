package com.ecomvision.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeographyDTO {
    private String countryCode; // e.g. "US", "CN"
    private Integer count;      // user count or sales amount
}