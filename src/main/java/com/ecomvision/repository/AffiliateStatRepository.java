package com.ecomvision.repository;

import com.ecomvision.entity.AffiliateStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliateStatRepository extends JpaRepository<AffiliateStat, Long> {
}