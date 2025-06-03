package com.ecomvision.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cost;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Defines a many-to-many relationship between Transaction and Product.
     *
     * By default, JPA uses FetchType.EAGER for @ManyToMany, which means it loads all associated products
     * immediately when a transaction is fetched. This can cause performance issues or recursive joins
     * when rendering DTOs or querying large datasets.
     *
     * Setting fetch = FetchType.LAZY ensures that products are only loaded when explicitly accessed,
     * avoiding unnecessary joins and improving performance.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "transaction_product",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
}