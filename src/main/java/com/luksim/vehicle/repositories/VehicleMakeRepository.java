package com.luksim.vehicle.repositories;

import com.luksim.vehicle.models.VehicleMake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VehicleMakeRepository extends JpaRepository<VehicleMake, Long> {
}
