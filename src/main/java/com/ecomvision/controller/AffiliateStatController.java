package com.ecomvision.controller;
import com.ecomvision.dto.AffiliateStatDTO;
import com.ecomvision.repository.AffiliateStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AffiliateStatController {

    private final AffiliateStatRepository affiliateStatRepository;

    @GetMapping("/affiliate-stats")
    public List<AffiliateStatDTO> getAffiliateStats() {
        return affiliateStatRepository.findAll().stream()
                .map(stat -> AffiliateStatDTO.builder()
                        .id(stat.getId())
                        .userId(stat.getUser().getId())
                        .affiliateSales(
                                stat.getAffiliateSales().stream()
                                        .map(String::valueOf)
                                        .collect(Collectors.toList())
                        )
                        .build())
                .toList();
    }
}