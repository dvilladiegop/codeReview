package com.example.codeReview11.controller;


import com.example.codeReview11.service.IVehicleService;
import com.example.codeReview11.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    // 11. Obtener la capacidad promedio de personas por marca

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getCapacityAverageByBrand(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageByBrand(brand), HttpStatus.OK);
    }
}
