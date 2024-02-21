package com.luksim.vehicle.controllers;

import com.luksim.vehicle.models.VehicleModel;
import com.luksim.vehicle.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/models")
public class VehicleModelController {
    private final VehicleModelRepository vehicleModelRepository;

    @Autowired
    public VehicleModelController(VehicleModelRepository vehicleModelRepository) {
        this.vehicleModelRepository = vehicleModelRepository;
    }

    @GetMapping
    public ResponseEntity<List<VehicleModel>> getVehicleModels() {
        List<VehicleModel> vehicleModels = vehicleModelRepository.findAll();

        if (vehicleModels.isEmpty()) {
            return new ResponseEntity<>(null, null, 204);
        }

        return new ResponseEntity<>(vehicleModels, null, 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleModel> getVehicleModelById(@PathVariable Long id) {
        VehicleModel vehicleModel = vehicleModelRepository.findById(id).orElse(null);

        if (vehicleModel == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        return new ResponseEntity<>(vehicleModel, null, 200);
    }

    @PostMapping
    public ResponseEntity<VehicleModel> createVehicleModel(@RequestBody VehicleModel vehicleModel) {
        VehicleModel newVehicleModel = vehicleModelRepository.save(vehicleModel);

        return new ResponseEntity<>(newVehicleModel, null, 201);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleModel> updateVehicleModel(@PathVariable Long id, @RequestBody VehicleModel vehicleModel) {
        VehicleModel existingVehicleModel = vehicleModelRepository.findById(id).orElse(null);

        if (existingVehicleModel == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        existingVehicleModel.setName(vehicleModel.getName());
        existingVehicleModel.setMakeId(vehicleModel.getMakeId());
        existingVehicleModel.setBodyType(vehicleModel.getBodyType());

        VehicleModel updatedVehicleModel = vehicleModelRepository.save(existingVehicleModel);

        return new ResponseEntity<>(updatedVehicleModel, null, 200);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleModel> deleteVehicleModel(@PathVariable Long id) {
        VehicleModel vehicleModel = vehicleModelRepository.findById(id).orElse(null);

        if (vehicleModel == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        vehicleModelRepository.delete(vehicleModel);

        return new ResponseEntity<>(null, null, 204);
    }
}
