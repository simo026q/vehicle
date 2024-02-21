package com.luksim.vehicle.repositories;

import com.luksim.vehicle.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
