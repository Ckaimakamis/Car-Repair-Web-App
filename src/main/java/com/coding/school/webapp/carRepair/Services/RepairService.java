package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public interface RepairService {


    Repair findByCost(double cost);

    Repair findByStage(Repair.RepairStage stage);

    Repair findByOperations(String operations);

    Repair findByType(Repair.RepairType type);

    void registerRepair(Repair repair, Vehicle vehicle) throws AuthenticationException;

    Repair findByDateTime(Timestamp dateTime);

    List<Repair> findNextRepairs(int size);

    List<Repair> findByVehicle(Vehicle vehicle);
}
