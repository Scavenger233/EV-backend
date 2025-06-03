package com.ecomvision.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "monthly_product_stat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonthlyProductStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month_name")
    private String monthName;

    private Integer totalSales;

    private Integer totalUnits;

    @ManyToOne
    @JoinColumn(name = "product_stat_id")
    private ProductStat productStat;
}