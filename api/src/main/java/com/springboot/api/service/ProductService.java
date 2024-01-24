package com.springboot.api.service;

import com.springboot.api.data.dto.ProductDto;
import com.springboot.api.data.dto.ProductResponseDto;

// 예제 6.21
public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

}
