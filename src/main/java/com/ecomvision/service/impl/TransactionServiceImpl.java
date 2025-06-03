package com.ecomvision.service.impl;

import com.ecomvision.dto.TransactionDTO;
import com.ecomvision.entity.Transaction;
import com.ecomvision.service.TransactionService;
import com.ecomvision.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<TransactionDTO> getTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable)
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class));
    }

    @Override
    public List<TransactionDTO> getTransactionsByIds(List<Long> ids) {
        return transactionRepository.findAllById(ids).stream()
                .map(this::convertToDTO)
                .toList();
    }


    private TransactionDTO convertToDTO(Transaction tx) {
        return TransactionDTO.builder()
                .id(tx.getId())
                .userId(tx.getUser().getId())
                .cost(tx.getCost())
                .createdAt(tx.getCreatedAt().toString())
                .productIds(tx.getProducts().stream()
                        .map(p -> p.getId().toString())
                        .toList())
                .build();
    }
}