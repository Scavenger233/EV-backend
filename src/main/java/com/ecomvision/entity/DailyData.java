package com.ecomvision.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyData {
    private String date;
    private Integer totalSales;
    private Integer totalUnits;
}