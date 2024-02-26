package com.example.codeReview11.service;

import com.example.codeReview11.dto.CapacityByBrandDto;
import com.example.codeReview11.dto.VehicleDto;
import com.example.codeReview11.entity.Vehicle;
import com.example.codeReview11.exception.NotFoundException;
import com.example.codeReview11.repository.IVehicleRepository;
import com.example.codeReview11.repository.VehicleRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(this::convertVehicleToDto)
                .collect(Collectors.toList());
    }


    @Override
    public List<CapacityByBrandDto> averageByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> brandVehicles = vehicleList.stream().filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());

        if (brandVehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos de esa marca: " + brand);
        }
        double averageCapacity = brandVehicles.stream().mapToInt(Vehicle::getPassengers).average()
                .orElse(0.0);

        return List.of(new CapacityByBrandDto(brand, averageCapacity));
    }

    private VehicleDto convertVehicleToDto(Vehicle v){
        return new VehicleDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getRegistration(),
                v.getColor(),
                v.getYear(),
                v.getMax_speed(),
                v.getPassengers(),
                v.getFuel_type(),
                v.getTransmission(),
                v.getLength(),
                v.getWidth(),
                v.getWeight());
    }
}
