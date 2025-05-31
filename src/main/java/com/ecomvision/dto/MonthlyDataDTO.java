package com.ecomvision.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyDataDTO {
    private String month;
    private Integer totalSales;
    private Integer totalUnits;
}
