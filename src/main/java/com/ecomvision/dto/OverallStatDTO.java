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
    private Long id;
    private Integer totalCustomers;
    private Integer yearlySalesTotal;
    private Integer yearlyTotalSoldUnits;
    private Integer year;
    private List<MonthlyDataDTO> monthlyData;
    private List<DailyDataDTO> dailyData;
    private Map<String, Integer> salesByCategory;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}