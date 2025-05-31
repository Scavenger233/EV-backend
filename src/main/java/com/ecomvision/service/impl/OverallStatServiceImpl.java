package com.ecomvision.service.impl;

import com.ecomvision.dto.*;
import com.ecomvision.entity.*;
import com.ecomvision.repository.OverallStatRepository;
import com.ecomvision.service.OverallStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    /**
     * Convert entity to DTO to simplify data exposed to frontend
     */
    private OverallStatDTO convertToDTO(OverallStat stat) {
        return OverallStatDTO.builder()
                .id(stat.getId())
                .totalCustomers(stat.getTotalCustomers())
                .yearlySalesTotal(stat.getYearlySalesTotal())
                .yearlyTotalSoldUnits(stat.getYearlyTotalSoldUnits())
                .year(stat.getStatYear())
                .monthlyData(stat.getMonthlyData().stream()
                        .map(m -> new MonthlyDataDTO(m.getMonthName(), m.getTotalSales(), m.getTotalUnits()))
                        .collect(Collectors.toList()))
                .dailyData(stat.getDailyData().stream()
                        .map(d -> new DailyDataDTO(d.getDate(), d.getTotalSales(), d.getTotalUnits()))
                        .collect(Collectors.toList()))
                .salesByCategory(stat.getSalesByCategory())
                .createdAt(stat.getCreatedAt())
                .updatedAt(stat.getUpdatedAt())
                .build();
    }
}