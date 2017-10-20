package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
    Repair findByDateTime (Timestamp dateTime);

    default Repair findByID(Long ID) {
        return null;
    }

    Repair findByCost(double cost);

    Repair findByStage(Repair.RepairStage stage);


}
