package com.example.cafebills.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BillRequestDto {
    private double price;
    private LocalDateTime date;
    private List<ProductRequestDto> productList;
}
