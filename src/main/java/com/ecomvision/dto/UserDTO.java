package com.ecomvision.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String state;
    private String country;
    private String occupation;
    private String phoneNumber;
    private String role;
    private List<Long> transactionIds;
}