package com.example.cafebills.service;

import com.example.cafebills.dto.ProductRequestDto;
import com.example.cafebills.dto.ProductResponseDto;
import com.example.cafebills.entity.Product;
import com.example.cafebills.mapper.ProductDtoMapper;
import com.example.cafebills.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoMapper productDtoMapper;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productDtoMapper.toEntity(requestDto);
        Product savedProduct = productRepository.save(product);
        return productDtoMapper.toDto(savedProduct);
    }

    public ProductResponseDto getProductById(UUID productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return (product != null) ? productDtoMapper.toDto(product) : null;
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productDtoMapper::toDto)
                .toList();
    }

    public boolean deleteProduct(UUID productId) {
        if (!productRepository.existsById(productId)) {
            return false;
        }
        productRepository.deleteById(productId);
        return true;
    }
}
