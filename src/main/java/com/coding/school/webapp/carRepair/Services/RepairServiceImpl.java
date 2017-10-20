package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Exceptions.RepairExistException;
import com.coding.school.webapp.carRepair.Exceptions.UserExistException;
import com.coding.school.webapp.carRepair.Repositories.RepairRepository;
  import com.coding.school.webapp.carRepair.Domain.Owner;
  import com.coding.school.webapp.carRepair.Domain.Repair;
  import com.coding.school.webapp.carRepair.Exceptions.UserExistException;
  import com.coding.school.webapp.carRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.security.core.AuthenticationException;
  import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;

@Service
@Transactional
public class RepairServiceImpl implements RepairService {


    @Autowired
    private RepairRepository repairRepository;


    public Repair findByCost(Double cost){
        Repair repair = repairRepository.findByCost(cost);
        return repairRepository.findByCost(cost);
    }
    @Override
    public Repair    findByStage(Repair.RepairStage stage){
        Repair repair =repairRepository.findByStage(stage);
        return repair;
    }

    @Override
    public Repair findByOperations(String operations){
        Repair repair =repairRepository.findByOperations(operations);
        return   repair;
    }
    @Override
    public Repair findByType(Repair.RepairType type){
        Repair repair =repairRepository.findByType(type);
        return   repair;
       }
    @Override
    public Repair findByDateTime (Timestamp dateTime){
        return repairRepository.findByDateTime(dateTime);
    }
    @Override
    public void registerRepair(Repair repair) throws AuthenticationException {
        Repair existedRepair;
        existedRepair = repairRepository.findOne(repair.getID());
        if(existedRepair== null){
            repairRepository.save(repair);
           }else {
               throw new RepairExistException("Repair already exists!");
           }
       }
}





   /* @Override
    public ArrayList<Repair> findAll() {
        ArrayList<Repair> repairs = (ArrayList<Repair>) repository.findAll();
        return repairs;
    }

    @Override
    public Repair findByDateTime(String dateTime) {
        return repairRepository.findByDateTime(dateTime);
    }
}
