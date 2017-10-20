package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface RepairService {


   /* ArrayList<Repair> findAll();  */


    Repair findById(Long ID);

    Repair findByCost(Double cost);

    Repair findByStage(Repair.RepairStage stage);

    Repair findByOperations(String operations);

    Repair findByType(Repair.RepairType type);


    void registerRepair(Repair repair);
    Repair findByDateTime (Timestamp dateTime);
}
