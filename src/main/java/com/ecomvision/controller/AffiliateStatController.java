package com.ecomvision.controller;

import com.ecomvision.dto.AffiliateStatDTO;
import com.ecomvision.service.AffiliateStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affiliate-stats")
@RequiredArgsConstructor
public class AffiliateStatController {

    private final AffiliateStatService affiliateStatService;

    /**
     * GET /api/affiliate-stats
     * Return list of affiliate sales grouped by user
     */
    @GetMapping
    public List<AffiliateStatDTO> getAllAffiliateStats() {
        return affiliateStatService.getAllAffiliateStats();
    }
}