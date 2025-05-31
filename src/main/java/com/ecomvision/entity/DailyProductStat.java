package com.ecomvision.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "daily_product_stat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DailyProductStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private Integer totalSales;

    private Integer totalUnits;

    @ManyToOne
    @JoinColumn(name = "product_stat_id")
    private ProductStat productStat;
}