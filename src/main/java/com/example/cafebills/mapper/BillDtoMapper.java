package com.example.cafebills.mapper;

import com.example.cafebills.dto.BillRequestDto;
import com.example.cafebills.dto.BillResponseDto;
import com.example.cafebills.dto.ProductResponseDto;
import com.example.cafebills.entity.Bill;
import com.example.cafebills.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BillDtoMapper {

    private final ProductDtoMapper productDtoMapper;

    public Bill toEntity(BillRequestDto requestDto) {
        Bill bill = new Bill();
        bill.setPrice(requestDto.getPrice());
        List<Product> productList = requestDto.getProductList().stream()
                .map(productDtoMapper::toEntity)
                .toList();
        bill.setProductList(productList);
        return bill;
    }

    public BillResponseDto toDto(Bill bill) {
        BillResponseDto responseDto = new BillResponseDto();
        responseDto.setId(bill.getId());
        responseDto.setPrice(bill.getPrice());
        List<ProductResponseDto> productList = bill.getProductList().stream()
                .map(productDtoMapper::toDto)
                .toList();
        responseDto.setProductList(productList);
        return responseDto;
    }
}

