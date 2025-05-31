package com.ecomvision.service.impl;

import com.ecomvision.dto.UserDTO;
import com.ecomvision.entity.User;
import com.ecomvision.service.UserService;
import com.ecomvision.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        /*
         * This method converts a User entity to a UserDTO object.
         *
         * Reason: Directly returning the full User entity (with nested Transaction list)
         * could cause infinite recursion during JSON serialization, since:
         * - User → List<Transaction> → each Transaction has a User field → back to User
         *
         * To avoid this and keep the JSON response lightweight and flat, we:
         * - Only extract transaction IDs (List<Long>) instead of full Transaction objects
         * - Return a simplified DTO with only essential fields needed by frontend
         *
         * This also ensures that we decouple our frontend from database structure and
         * avoid performance/memory issues when dealing with deeply nested data.
         */
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .city(user.getCity())
                .state(user.getState())
                .country(user.getCountry())
                .occupation(user.getOccupation())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole())
                .transactionIds(
                        user.getTransactions() != null ?
                                user.getTransactions().stream()
                                        .map(txn -> txn.getId())
                                        .collect(Collectors.toList())
                                : List.of()
                )
                .build();
    }
}