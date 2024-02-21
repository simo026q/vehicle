package com.luksim.vehicle.controllers;

import com.luksim.vehicle.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles/makes")
public class VehicleMakeController {
    private final VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    public VehicleMakeController(VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }
}
