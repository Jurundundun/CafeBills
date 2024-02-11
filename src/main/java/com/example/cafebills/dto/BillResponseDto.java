package com.example.cafebills.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BillResponseDto {
    private UUID id;
    private double price;
    private LocalDateTime date;
    private List<ProductResponseDto> productList;
}




