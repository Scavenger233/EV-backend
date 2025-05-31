package com.ecomvision.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product_stat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer yearlySalesTotal;

    private Integer yearlyTotalSoldUnits;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "productStat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonthlyProductStat> monthlyData;

    @OneToMany(mappedBy = "productStat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyProductStat> dailyData;
}