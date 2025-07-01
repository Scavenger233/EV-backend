package com.ecomvision.service;

import com.ecomvision.dto.*;

import java.util.List;
import java.util.Map;

public interface OverallStatService {
    List<OverallStatDTO> getAllOverallStats();

    List<DailyDataDTO> getDailySales();

    List<MonthlyDataDTO> getMonthlySales();

    Map<String, Integer> getSalesByCategory();

    DashboardStatsDTO getDashboardStats();
    List<GeographyDTO> getGeographyStats();

}