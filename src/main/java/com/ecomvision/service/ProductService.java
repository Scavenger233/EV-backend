package com.ecomvision.service;

import com.ecomvision.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
}