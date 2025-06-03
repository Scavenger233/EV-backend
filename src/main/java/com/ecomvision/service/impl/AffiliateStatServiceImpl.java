package com.ecomvision.service.impl;

import com.ecomvision.dto.AffiliateStatDTO;
import com.ecomvision.entity.AffiliateStat;
import com.ecomvision.service.AffiliateStatService;
import com.ecomvision.repository.AffiliateStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AffiliateStatServiceImpl implements AffiliateStatService {

    private final AffiliateStatRepository affiliateStatRepository;

    @Override
    public List<AffiliateStatDTO> getAllAffiliateStats() {
        return affiliateStatRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Convert AffiliateStat entity to a DTO for safe and minimal frontend exposure
     */
    private AffiliateStatDTO convertToDTO(AffiliateStat stat) {
        return AffiliateStatDTO.builder()
                .id(stat.getId())
                .userId(stat.getUser().getId())
                .affiliateSales(
                        stat.getAffiliateSales().stream()
                                .map(String::valueOf)
                                .collect(Collectors.toList())
                )
                .build();
    }
}