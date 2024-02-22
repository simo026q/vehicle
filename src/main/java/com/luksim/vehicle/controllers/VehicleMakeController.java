package com.luksim.vehicle.controllers;

import com.luksim.vehicle.models.VehicleMake;
import com.luksim.vehicle.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles/makes")
public class VehicleMakeController extends CrudController<VehicleMake, Long> {
    @Autowired
    public VehicleMakeController(VehicleMakeRepository vehicleMakeRepository) {
        super(vehicleMakeRepository);
    }

    @Override
    protected void updateEntity(VehicleMake existingVehicleMake, VehicleMake vehicleMake) {
        existingVehicleMake.setName(vehicleMake.getName());
        existingVehicleMake.setOriginCountry(vehicleMake.getOriginCountry());
    }
}
