package com.ecomvision.service;

import com.ecomvision.dto.DailyDataDTO;
import com.ecomvision.dto.MonthlyDataDTO;
import com.ecomvision.dto.OverallStatDTO;

import java.util.List;
import java.util.Map;

public interface OverallStatService {
    List<OverallStatDTO> getAllOverallStats();

    List<DailyDataDTO> getDailySales();

    List<MonthlyDataDTO> getMonthlySales();

    Map<String, Integer> getSalesByCategory();

}