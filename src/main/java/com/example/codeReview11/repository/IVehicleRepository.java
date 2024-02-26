package com.example.codeReview11.repository;

import com.example.codeReview11.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
}
