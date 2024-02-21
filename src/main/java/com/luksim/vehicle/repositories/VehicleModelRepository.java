package com.luksim.vehicle.repositories;

import com.luksim.vehicle.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VehicleModelRepository extends JpaRepository<VehicleModel, Long> {
}
