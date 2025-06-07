package com.ecomvision.service.impl;

import com.ecomvision.dto.*;
import com.ecomvision.entity.*;
import com.ecomvision.repository.OverallStatRepository;
import com.ecomvision.service.OverallStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OverallStatServiceImpl implements OverallStatService {

    private final OverallStatRepository overallStatRepository;

    @Override
    public List<OverallStatDTO> getAllOverallStats() {
        return overallStatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DailyDataDTO> getDailySales() {
        OverallStat stat = overallStatRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new RuntimeException("No overall stat data found"));

        System.out.println("🔍 OverallStatServiceImpl triggered");

        return stat.getDailyData().stream()
                .map(d -> DailyDataDTO.builder()
                        .date(d.getDate())
                        .totalSales(d.getTotalSales())
                        .totalUnits(d.getTotalUnits())
                        .build())
                .toList();
    }

    @Override
    public List<MonthlyDataDTO> getMonthlySales() {
        return overallStatRepository.findAll().stream()
                .findFirst()
                .map(stat -> stat.getMonthlyData().stream()
                        .map(monthly -> new MonthlyDataDTO(
                                monthly.getMonthName(),
                                monthly.getTotalSales(),
                                monthly.getTotalUnits()))
                        .toList())
                .orElse(Collections.emptyList());
    }

    @Override
    public Map<String, Integer> getSalesByCategory() {
        return overallStatRepository.findAll()
                .stream()
                .findFirst()
                .map(OverallStat::getSalesByCategory)
                .orElse(Map.of());
    }




    /**
     * Convert entity to DTO to simplify data exposed to frontend
     */
    private OverallStatDTO convertToDTO(OverallStat stat) {
        return OverallStatDTO.builder()
                .totalCustomers(stat.getTotalCustomers())
                .yearlySalesTotal(stat.getYearlySalesTotal())
                .yearlyTotalSoldUnits(stat.getYearlyTotalSoldUnits())
                .year(stat.getStatYear())
                .build();
    }
}