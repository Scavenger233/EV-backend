package com.ecomvision.repository;

import com.ecomvision.entity.ProductStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStatRepository extends JpaRepository<ProductStat, Long> {
}
