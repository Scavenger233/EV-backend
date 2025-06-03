package com.ecomvision.controller;

import com.ecomvision.dto.DailyDataDTO;
import com.ecomvision.dto.MonthlyDataDTO;
import com.ecomvision.dto.OverallStatDTO;
import com.ecomvision.service.OverallStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/overall-stats")
@RequiredArgsConstructor
public class OverallStatController {

    private final OverallStatService overallStatService;

    /**
     * GET /api/overall-stats
     * Return list of high-level business metrics for dashboard summary
     */
    @GetMapping
    public List<OverallStatDTO> getAllStats() {
        return overallStatService.getAllOverallStats();
    }

    @GetMapping("/daily")
    public List<DailyDataDTO> getDailySales() {
        System.out.println("📊 [GET] /api/overall-stat/daily triggered");
        return overallStatService.getDailySales();
    }

    @GetMapping("/monthly")
    public List<MonthlyDataDTO> getMonthlySales() {
        return overallStatService.getMonthlySales();
    }

    @GetMapping("/breakdown")
    public Map<String, Integer> getSalesByCategory() {
        System.out.println("📊 [GET] /api/overall-stats/breakdown triggered");
        return overallStatService.getSalesByCategory();
    }



}