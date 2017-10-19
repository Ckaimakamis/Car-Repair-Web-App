package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
//    @Autowired
//    VehicleRepository vehicleRepository;
//
//    @Override
//    public Vehicle findById(Long ID){
//        return vehicleRepository.findOne(ID);
//    }
}
