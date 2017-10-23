package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Exceptions.RepairExistException;
import com.coding.school.webapp.carRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {


    @Autowired
    RepairRepository repairRepository;

    @Override
    public Repair findByCost(double cost){
        return repairRepository.findByCost(cost);
    }
    @Override
    public Repair findByStage(Repair.RepairStage stage){
        return repairRepository.findByStage(stage);
    }

    @Override
    public Repair findByOperations(String operations){
        return repairRepository.findByOperations(operations);
    }

    @Override
    public Repair findByType(Repair.RepairType type){
        return   repairRepository.findByType(type);
       }

    @Override
    public Repair findByDateTime (Timestamp dateTime){
        return repairRepository.findByDateTime(dateTime);
    }

    @Override
    public List<Repair> findByVehicle(Vehicle vehicle){
        return repairRepository.findByVehicle(vehicle);
    }

    @Override
    public void registerRepair(Repair repair) throws AuthenticationException {
        Repair existedRepair= repairRepository.findByOperations(repair.getOperations());
        if(existedRepair== null){
            repairRepository.save(repair);
           }else {
               throw new RepairExistException("Repair already exists!");
           }
       }
}
