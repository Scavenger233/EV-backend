package com.ecomvision.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "affiliate_stat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AffiliateStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ElementCollection
    @CollectionTable(name = "affiliate_sales", joinColumns = @JoinColumn(name = "affiliate_stat_id"))
    @Column(name = "transaction_id")
    private List<Long> affiliateSales;
}