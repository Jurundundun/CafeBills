package com.example.cafebills.controller;

import com.example.cafebills.entity.Product;
import com.example.cafebills.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @PostMapping
    public Product createProduct(@RequestParam String name) {
        return productService.createProduct(name);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable UUID productId) {
        return productService.getProductById(productId);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable UUID productId) {
        productService.deleteProduct(productId);
    }
}
