package com.example.cafebills.controller;

import com.example.cafebills.dto.BillDto;
import com.example.cafebills.entity.Bill;
import com.example.cafebills.entity.Product;
import com.example.cafebills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping
    public Bill createBill(@RequestParam double price, @RequestBody List<Product> productList) {
        return billService.createBill(price, productList);
    }

    @GetMapping("/{billId}")
    public Bill getBillById(@PathVariable UUID billId) {
        return billService.getBillById(billId);
    }

    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @DeleteMapping("/{billId}")
    public void deleteBill(@PathVariable UUID billId) {
        billService.deleteBill(billId);
    }
}
