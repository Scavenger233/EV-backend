package com.ecomvision.service;

import com.ecomvision.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
}