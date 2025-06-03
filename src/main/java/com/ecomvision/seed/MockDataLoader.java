package com.ecomvision.seed;
import com.ecomvision.entity.*;
import com.ecomvision.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MockDataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final ProductStatRepository productStatRepository;
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final OverallStatRepository overallStatRepository;
    private final AffiliateStatRepository affiliateStatRepository;

    @Override
    public void run(String... args) {

        // ---------- PRODUCT ----------
        Product product = null;
        if (productRepository.count() == 0) {
            product = Product.builder()
                    .name("Port Beckley")
                    .description("Revision of Nonaut Sub in Mouth/Throat, Via Opening")
                    .category("clothing")
                    .price(311.71)
                    .rating(1.15)
                    .supply(1320)
                    .build();
            productRepository.save(product);
        } else {
            product = productRepository.findAll().get(0); // Get first existing
        }

        // ---------- PRODUCT STAT ----------
        if (productStatRepository.count() == 0 && product != null) {
            ProductStat stat = ProductStat.builder()
                    .product(product)
                    .yearlySalesTotal(7152)
                    .yearlyTotalSoldUnits(1414)
                    .build();
            productStatRepository.save(stat);
        }

        // ---------- USER ----------
        User user = null;
        if (userRepository.count() == 0) {
            user = User.builder()
                    .name("Konstantine")
                    .email("kranstead0@narod.ru")
                    .password("omMDCh") // plain text for demo
                    .city("Nurabelen")
                    .state(null)
                    .country("ID")
                    .occupation("Computer Systems Analyst I")
                    .phoneNumber("8346315874")
                    .role("superadmin")
                    .build();
            userRepository.save(user);
        } else {
            user = userRepository.findAll().get(0);
        }

        // ---------- TRANSACTION ----------
        Transaction txn = null;
        if (transactionRepository.count() == 0 && user != null && product != null) {
            txn = Transaction.builder()
                    .user(user)
                    .products(Set.of(product))
                    .cost(product.getPrice())
                    .createdAt(LocalDateTime.now())
                    .build();
            transactionRepository.save(txn);
        }

        // ---------- OVERALL STAT ----------
        if (overallStatRepository.count() == 0) {
            List<MonthlyData> monthlyData = List.of(
                    new MonthlyData("January", 6166, 17738),
                    new MonthlyData("February", 9412, 50516),
                    new MonthlyData("March", 1081, 8156)
            );

            List<DailyData> dailyData = new java.util.ArrayList<>();
            for (int i = 0; i < 30; i++) {
                LocalDate date = LocalDate.of(2021, 2, 1).plusDays(i);
                dailyData.add(DailyData.builder()
                        .date(date.toString())
                        .totalSales(2000 + (int)(Math.random() * 3000))
                        .totalUnits(20 + (int)(Math.random() * 80))
                        .build());
            }


            Map<String, Integer> categorySales = Map.of(
                    "shoes", 6515,
                    "clothing", 22803,
                    "accessories", 16288,
                    "misc", 19545
            );

            OverallStat stat = OverallStat.builder()
                    .totalCustomers(5251)
                    .yearlySalesTotal(65152)
                    .yearlyTotalSoldUnits(12969)
                    .statYear(2021)
                    .monthlyData(monthlyData)
                    .dailyData(dailyData)
                    .salesByCategory(categorySales)
                    .createdAt(LocalDate.of(1983, 1, 10))
                    .updatedAt(LocalDate.of(2019, 7, 6))
                    .build();

            overallStatRepository.save(stat);
        }

        // ---------- AFFILIATE STAT ----------
        if (affiliateStatRepository.count() == 0 && user != null) {
            List<Transaction> transactions = transactionRepository.findAll();
            if (!transactions.isEmpty()) {
                List<Long> txnIds = transactions.stream()
                        .limit(3)
                        .map(Transaction::getId)
                        .toList();

                AffiliateStat stat = AffiliateStat.builder()
                        .user(user)
                        .affiliateSales(txnIds)
                        .build();

                affiliateStatRepository.save(stat);
            }
        }
    }
}
