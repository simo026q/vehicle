package com.luksim.vehicle.controllers;

import com.luksim.vehicle.models.VehicleMake;
import com.luksim.vehicle.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/makes")
public class VehicleMakeController {
    private final VehicleMakeRepository vehicleMakeRepository;

    @Autowired
    public VehicleMakeController(VehicleMakeRepository vehicleMakeRepository) {
        this.vehicleMakeRepository = vehicleMakeRepository;
    }

    @GetMapping
    public ResponseEntity<List<VehicleMake>> getVehicleMakes() {
        List<VehicleMake> vehicleMakes = vehicleMakeRepository.findAll();

        if (vehicleMakes.isEmpty()) {
            return new ResponseEntity<>(null, null, 204);
        }

        return new ResponseEntity<>(vehicleMakes, null, 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleMake> getVehicleMakeById(@PathVariable Long id) {
        VehicleMake vehicleMake = vehicleMakeRepository.findById(id).orElse(null);

        if (vehicleMake == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        return new ResponseEntity<>(vehicleMake, null, 200);
    }

    @PostMapping
    public ResponseEntity<VehicleMake> createVehicleMake(@RequestBody VehicleMake vehicleMake) {
        VehicleMake newVehicleMake = vehicleMakeRepository.save(vehicleMake);

        return new ResponseEntity<>(newVehicleMake, null, 201);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleMake> updateVehicleMake(@PathVariable Long id, @RequestBody VehicleMake vehicleMake) {
        VehicleMake existingVehicleMake = vehicleMakeRepository.findById(id).orElse(null);

        if (existingVehicleMake == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        existingVehicleMake.setName(vehicleMake.getName());
        existingVehicleMake.setOriginCountry(vehicleMake.getOriginCountry());

        VehicleMake updatedVehicleMake = vehicleMakeRepository.save(existingVehicleMake);

        return new ResponseEntity<>(updatedVehicleMake, null, 200);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleMake> deleteVehicleMake(@PathVariable Long id) {
        VehicleMake vehicleMake = vehicleMakeRepository.findById(id).orElse(null);

        if (vehicleMake == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        vehicleMakeRepository.delete(vehicleMake);

        return new ResponseEntity<>(vehicleMake, null, 200);
    }
}
