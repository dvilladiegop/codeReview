package com.example.codeReview11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CapacityByBrandDto {
    private String brand;
    private double average_capacity;
}
