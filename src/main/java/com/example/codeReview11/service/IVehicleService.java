package com.example.codeReview11.service;


import com.example.codeReview11.dto.CapacityByBrandDto;
import com.example.codeReview11.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    List<CapacityByBrandDto> averageByBrand(String brand);
}
