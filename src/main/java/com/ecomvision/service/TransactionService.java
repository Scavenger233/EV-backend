package com.ecomvision.service;

import com.ecomvision.dto.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();

    Page<TransactionDTO> getTransactions(Pageable pageable);
}