package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByPlateNumberAndModel(String plate, String Model);

    Vehicle findByPlateNumber(String plate);

    Vehicle findByOwner(Owner owner);

    @Transactional
    @Modifying
    @Query("UPDATE Vehicle o SET o.plateNumber=?1, o.model=?2, " +
            "o.year=?3, o.color=?4 WHERE o.plateNumber=?1")
    void updateVehicle(String plateNumber, String model, String year, String color);
}
