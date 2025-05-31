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

    /**
     * Foreign key pointing to the user who is an affiliate.
     */
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * List of transactions generated through this affiliate.
     */
    @ManyToMany
    @JoinTable(
            name = "affiliate_stat_transactions",
            joinColumns = @JoinColumn(name = "affiliate_stat_id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private List<Transaction> affiliateSales;
}