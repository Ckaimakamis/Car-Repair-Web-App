package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Converters.RepairConverter;
import com.coding.school.webapp.carRepair.Domain.Parts;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Exceptions.RepairExistException;
import com.coding.school.webapp.carRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    public Repair findByType(Repair.RepairType type){
        return   repairRepository.findByType(type);
       }

    @Override
    public Repair findByDateTime (Timestamp dateTime){
        return repairRepository.findByDateTime(dateTime);
    }

    @Override
    public List<Repair> findNextRepairs(int size) {
        LocalDateTime now = RepairConverter.getStartOfDay(LocalDateTime.now());
        List<Repair> repairs = repairRepository.findRepairs(now);
        if(repairs.size() > size){
            return repairs.subList(0, size-1);
        }
        return repairs;
    }

    @Override
    public List<Repair> findByVehicle(Vehicle vehicle){
        return repairRepository.findByVehicle(vehicle);
    }

    @Override
    public void registerRepair(Repair repair, Vehicle vehicle) throws AuthenticationException {
        repair.setVehicle(vehicle);
        try{
//            List<Parts> parts = (List<Parts>) repair.getParts();
//            for(Parts part : parts){
//                part.setRepair(repair);
//            }
//            repair.setParts(parts);
            repairRepository.save(repair);
        } catch (Exception e) {
            throw new RepairExistException("Ooops! Something went wrong! Repair was not inserted");
        }
    }

    @Override
    public List<Repair> findOneDayRepairs (LocalDateTime dateTime){
        LocalDateTime startOfDay = RepairConverter.getStartOfDay(dateTime);
        LocalDateTime endOfDay = RepairConverter.getEndOfDay(dateTime);
        List<Repair> repairs = repairRepository.findOneDayRepairs(startOfDay, endOfDay);
        return repairs;
    }

    @Override
    public List<Repair> findManyDaysRepairs (LocalDateTime dateFrom , LocalDateTime dateTo){
        LocalDateTime startOfDay = RepairConverter.getStartOfDay(dateFrom);
        LocalDateTime endOfDay = RepairConverter.getEndOfDay(dateTo);

        return repairRepository.findOneDayRepairs(startOfDay, endOfDay);
    }

    @Override
    public void updateRepair(Repair repair) {
        repairRepository.updateRepair(repair.getDateTime(), repair.getType(),
                repair.getStage(), repair.getCost(), repair.getParts(), repair.getID());
    }

    @Override
    public Repair findRepair(Long id) {
        Repair repair = repairRepository.findOne(id);
        return  repair;
    }

    @Override
    public void deleteRepair(Repair repair) {
        repairRepository.delete(repair);
    }
}
