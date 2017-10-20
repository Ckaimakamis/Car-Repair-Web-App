 package com.coding.school.webapp.carRepair.Services;

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
   RepairRepository repairRepository;

    @Autowired
    private RepairRepository repository;

    @Override
    public Repair findById(Long ID){
        Repair repair = repository.findOne(ID);
        return repair;
    }

    @Override
    public Repair findByDateTime(String dateTime) {
        Repair repair = repository.findByDateTime(dateTime);
        return repairRepository.findByDateTime(dateTime);
    }

    @Override
    public Repair findByCost(Double cost){
        Repair repair = repository.findByCost(cost);
        return repairRepository.findByCost(cost);
    }
    @Override
    public Repair    findByStage(Repair.RepairStage stage){
        Repair repair =repository.findByStage(stage);
        return repairRepository.findByStage(stage);
    }

    @Override
    public Repair findByOperations(String operations){
        Repair repair =repository.findByOperations(operations);
        return  repairRepository.findByOperations(operations);
    }
    @Override
    public Repair findByType(Repair.RepairType type){
        Repair repair =repository.findByType(type);
        return repairRepository.findByType(type);
       }
    @Override
    public void registerRepair(Repair repair) throws AuthenticationException {
        Repair existedRepair= repairRepository.findById(repair.getID());
           if(existedRepair== null){
               repairRepository.save(repair);
           }else {
               throw new UserExistException("Email already exists!");
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
