package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.sql.Timestamp;
import java.util.ArrayList;

@Service
public interface RepairService {

    Repair findByCost(Double cost);

    Repair findByStage(Repair.RepairStage stage);

    Repair findByOperations(String operations);

    Repair findByType(Repair.RepairType type);

    void registerRepair(Repair repair) throws AuthenticationException;

    Repair findByDateTime (Timestamp dateTime);
}
