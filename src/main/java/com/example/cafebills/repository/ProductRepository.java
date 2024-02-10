package com.example.cafebills.repository;

import com.example.cafebills.entity.Bill;
import com.example.cafebills.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository  extends JpaRepository<Product, UUID> {
}
