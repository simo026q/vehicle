package com.luksim.vehicle.controllers;

import com.luksim.vehicle.models.Vehicle;
import com.luksim.vehicle.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        if (vehicles.isEmpty()) {
            return new ResponseEntity<>(null, null, 204);
        }

        return new ResponseEntity<>(vehicles, null, 200);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        return new ResponseEntity<>(vehicle, null, 200);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle newVehicle = vehicleRepository.save(vehicle);

        return new ResponseEntity<>(newVehicle, null, 201);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElse(null);

        if (existingVehicle == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        existingVehicle.setModelId(vehicle.getModelId());
        existingVehicle.setColor(vehicle.getColor());
        existingVehicle.setMileage(vehicle.getMileage());
        existingVehicle.setVin(vehicle.getVin());
        existingVehicle.setModelYear(vehicle.getModelYear());

        return new ResponseEntity<>(vehicleRepository.save(existingVehicle), null, 200);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null) {
            return new ResponseEntity<>(null, null, 404);
        }

        vehicleRepository.delete(vehicle);

        return new ResponseEntity<>(null, null, 204);
    }
}
