package com.ecomvision.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "overall_stat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OverallStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalCustomers;

    private Integer yearlySalesTotal;

    private Integer yearlyTotalSoldUnits;

    private Integer statYear;

    @ElementCollection
    @CollectionTable(name = "overall_stat_monthly", joinColumns = @JoinColumn(name = "stat_id"))
    @OrderColumn(name = "position")
    private List<MonthlyData> monthlyData;

    @ElementCollection
    @CollectionTable(name = "overall_stat_daily", joinColumns = @JoinColumn(name = "stat_id"))
    private List<DailyData> dailyData;

    @ElementCollection
    @CollectionTable(name = "overall_stat_sales_by_category", joinColumns = @JoinColumn(name = "stat_id"))
    @MapKeyColumn(name = "category")
    @Column(name = "sales")
    private Map<String, Integer> salesByCategory;

    private LocalDate createdAt;
    private LocalDate updatedAt;
}