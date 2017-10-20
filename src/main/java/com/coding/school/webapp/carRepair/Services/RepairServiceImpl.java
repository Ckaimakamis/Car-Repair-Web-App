package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Repositories.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ArrayList<Repair> findAll() {
        ArrayList<Repair> repairs = (ArrayList<Repair>) repository.findAll();
        return repairs;
    }

    @Override
    public Repair findByDateTime(Timestamp dateTime) {
        return repairRepository.findByDateTime(dateTime);
    }
}
