package com.ecomvision.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyData {

    @Column(name = "month_name")
    private String monthName;

    @Column(name = "monthly_total_sales")
    private Integer totalSales;

    @Column(name = "monthly_total_units")
    private Integer totalUnits;
}