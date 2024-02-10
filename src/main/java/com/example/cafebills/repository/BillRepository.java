package com.example.cafebills.repository;

import com.example.cafebills.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillRepository  extends JpaRepository<Bill, UUID> {
}
