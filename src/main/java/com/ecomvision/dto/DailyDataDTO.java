package com.ecomvision.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DailyDataDTO {
    private String date;
    private Integer totalSales;
    private Integer totalUnits;
}