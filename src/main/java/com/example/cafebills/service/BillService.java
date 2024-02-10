package com.example.cafebills.service;

import com.example.cafebills.dto.ProductDto;
import com.example.cafebills.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.cafebills.dto.BillDto;
import com.example.cafebills.entity.Bill;
import com.example.cafebills.repository.BillRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public Bill createBill(double price, List<Product> productList) {
        Bill bill = new Bill();
        bill.setPrice(price);
        bill.setProductList(productList);
        return billRepository.save(bill);
    }

    public Bill getBillById(UUID billId) {
        return billRepository.findById(billId).orElse(null);
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public void deleteBill(UUID billId) {
        billRepository.deleteById(billId);
    }
}

