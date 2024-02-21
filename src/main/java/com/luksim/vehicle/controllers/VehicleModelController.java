package com.luksim.vehicle.controllers;

import com.luksim.vehicle.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles/models")
public class VehicleModelController {
    private final VehicleModelRepository vehicleModelRepository;

    @Autowired
    public VehicleModelController(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }
}
