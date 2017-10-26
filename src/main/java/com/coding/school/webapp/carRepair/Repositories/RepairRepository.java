package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Parts;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.AuthenticationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    Repair findByPartsAndVehicle(List<Parts> parts, Vehicle vehicle);

    Repair findByCost(double cost);

    Repair findByStage(Repair.RepairStage stage);

    Repair findByOperations(String operations);

    Repair findByType(Repair.RepairType type);

    Repair findByDateTime (Timestamp dateTime);

    List<Repair> findByVehicle(Vehicle vehicle);

    @Query("SELECT u FROM Repair u WHERE " +
            "u.dateTime>?1 ORDER BY u.dateTime")
    List<Repair> findRepairs(LocalDateTime dateTime);

    @Query("SELECT r FROM Repair r WHERE " +
            "r.dateTime>=?1 AND r.dateTime<=?2")
    List<Repair> findOneDayRepairs(LocalDateTime startOfDay, LocalDateTime endOfDay);

    @Query("SELECT r FROM Repair r WHERE " +
            "r.dateTime>=?1 AND r.dateTime<=?2")
    List<Repair> findManyDaysRepairs(LocalDateTime startOfDay, LocalDateTime endOfDay);

    @Transactional
    @Modifying
    @Query("UPDATE Repair o SET o.dateTime=?1, o.type=?2, " +
            "o.stage=?3, o.cost=?4, o.operations=?5 WHERE o.ID=?6")
    void updateRepair(LocalDateTime dateTime, Repair.RepairType type, Repair.RepairStage stage,
                      double cost, String operations, Long id);
}
