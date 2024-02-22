package com.luksim.vehicle.controllers;

import com.luksim.vehicle.models.Vehicle;
import com.luksim.vehicle.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController extends CrudController<Vehicle, Long> {
    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        super(vehicleRepository);
    }

    @Override
    protected void updateEntity(Vehicle existingVehicle, Vehicle vehicle) {
        existingVehicle.setModelId(vehicle.getModelId());
        existingVehicle.setColor(vehicle.getColor());
        existingVehicle.setMileage(vehicle.getMileage());
        existingVehicle.setVin(vehicle.getVin());
        existingVehicle.setModelYear(vehicle.getModelYear());
    }
}
