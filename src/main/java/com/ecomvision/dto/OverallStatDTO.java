package com.ecomvision.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OverallStatDTO {
    private Integer totalCustomers;
    private Integer yearlySalesTotal;
    private Integer yearlyTotalSoldUnits;
    private Integer year;
}