package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.naming.AuthenticationException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {



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

}
