package com.luksim.vehicle.controllers;

import com.luksim.vehicle.models.VehicleModel;
import com.luksim.vehicle.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles/models")
public class VehicleModelController extends CrudController<VehicleModel, Long> {
    @Autowired
    public VehicleModelController(VehicleModelRepository vehicleModelRepository) {
        super(vehicleModelRepository);
    }

    @Override
    protected void updateEntity(VehicleModel existingVehicleModel, VehicleModel vehicleModel) {
        existingVehicleModel.setName(vehicleModel.getName());
        existingVehicleModel.setMakeId(vehicleModel.getMakeId());
        existingVehicleModel.setBodyType(vehicleModel.getBodyType());
    }
}
