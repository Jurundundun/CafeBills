package com.example.cafebills.service;

import com.example.cafebills.entity.Product;
import com.example.cafebills.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product createProduct(String name) {
        Product product = new Product();
        product.setName(name);
        return productRepository.save(product);
    }

    public Product getProductById(UUID productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
    }
}
