package com.ecomvision.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardStatsDTO {
    private int totalCustomers;
    private int yearlySalesTotal;
    private int yearlyTotalSoldUnits;

    private MonthlyStat thisMonthStats;
    private DailyStat todayStats;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MonthlyStat {
        private String month;
        private int totalSales;
        private int totalUnits;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DailyStat {
        private String date;
        private int totalSales;
        private int totalUnits;
    }
}