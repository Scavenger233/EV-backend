package com.ecomvision.controller;

import com.ecomvision.dto.OverallStatDTO;
import com.ecomvision.service.OverallStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}