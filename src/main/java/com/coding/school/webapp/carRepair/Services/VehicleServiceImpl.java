package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Exceptions.VehicleExistException;
import com.coding.school.webapp.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    public void registerVehicle(Vehicle vehicle){
        Vehicle existedVehicle = vehicleRepository.findByPlateNumberAndModel(vehicle.getPlateNumber(), vehicle.getModel());
        if(existedVehicle == null){
            vehicleRepository.save(vehicle);
        }else {
            throw new VehicleExistException("Vehicle already exists!");
        }
    }

    @Override
    public Vehicle findByPlateNumber(String plate) {
        return vehicleRepository.findByPlateNumber(plate);
    }
}
