package com.example.cafebills.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BillDto {
    private UUID id;
    private LocalDateTime date;
    private double price;
    private List<ProductDto> productList;

}

