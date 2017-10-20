package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByPlateNumberAndModel(String plate, String Model);

    Vehicle findByPlateNumber(String plate);
}
