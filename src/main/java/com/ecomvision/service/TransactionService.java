package com.ecomvision.service;

import com.ecomvision.dto.TransactionDTO;
import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();
}