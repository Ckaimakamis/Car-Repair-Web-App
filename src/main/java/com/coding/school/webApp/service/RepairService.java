package com.coding.school.webApp.service;

import com.coding.school.webApp.model.Repair;
import com.coding.school.webApp.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("RepairService")
public class RepairService {

    @Autowired
    @Qualifier("RepairRepository")
    private RepairRepository repository;

    public Repair findById(int ID){
        Repair repair = repository.findOne(ID);
        if(repair != null){
            return repair;
        } else{
            return null;
        }
    }
}
