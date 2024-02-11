package com.example.cafebills.service;

import com.example.cafebills.dto.BillRequestDto;
import com.example.cafebills.dto.BillResponseDto;
import com.example.cafebills.entity.Bill;
import com.example.cafebills.mapper.BillDtoMapper;
import com.example.cafebills.repository.BillRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;
    private final BillDtoMapper billDtoMapper;

    public BillResponseDto createBill(BillRequestDto requestDto) {
        Bill bill = billDtoMapper.toEntity(requestDto);
        Bill savedBill = billRepository.save(bill);
        return billDtoMapper.toDto(savedBill);
    }

    public BillResponseDto getBillById(@NotNull UUID billId) {
        Bill bill = billRepository.findById(billId).orElse(null);
        return (bill != null) ? billDtoMapper.toDto(bill) : null;
    }

    public List<BillResponseDto> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        return bills.stream()
                .map(billDtoMapper::toDto)
                .toList();
    }

    public boolean deleteBill(@NotNull UUID billId) {
        if (!billRepository.existsById(billId)) {
            return false;
        }
        billRepository.deleteById(billId);
        return true;
    }
}
