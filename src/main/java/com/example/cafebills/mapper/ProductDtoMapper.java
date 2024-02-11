package com.example.cafebills.mapper;

import com.example.cafebills.dto.ProductRequestDto;
import com.example.cafebills.dto.ProductResponseDto;
import com.example.cafebills.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public Product toEntity(ProductRequestDto requestDto) {
        Product product = new Product();
        product.setName(requestDto.getName());
        return product;
    }

    public ProductResponseDto toDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        return responseDto;
    }
}
