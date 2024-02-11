package com.example.cafebills.controller;

import com.example.cafebills.dto.BillRequestDto;
import com.example.cafebills.dto.BillResponseDto;
import com.example.cafebills.service.BillService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping
    public ResponseEntity<BillResponseDto> createBill(@RequestBody @Valid BillRequestDto requestDto) {
        BillResponseDto responseDto = billService.createBill(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping("/{billId}")
    public ResponseEntity<BillResponseDto> getBillById(@PathVariable @NotNull UUID billId) {
        BillResponseDto responseDto = billService.getBillById(billId);
        return responseDto != null ?
                ResponseEntity.ok(responseDto) :
                ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<BillResponseDto>> getAllBills() {
        List<BillResponseDto> responseDtoList = billService.getAllBills();
        if (responseDtoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(responseDtoList);
    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<Void> deleteBill(@PathVariable @NotNull UUID billId) {
        boolean deleted = billService.deleteBill(billId);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
