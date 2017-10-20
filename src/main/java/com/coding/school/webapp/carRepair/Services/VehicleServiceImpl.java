package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Exceptions.VehicleExistException;
import com.coding.school.webapp.carRepair.Repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
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

    @Override
    public Vehicle findByPlateNumberOrVat(String plate, String vat) {
        Vehicle vehicle = vehicleRepository.findByPlateNumber(plate);
        if(vat.equals("")){
            return vehicle;
        }
        if(vehicle.getOwner().getVat().equals(vat)){
            return vehicle;
        }else {
            return null;
        }
    }

    @Override
    public Vehicle findByOwner(Owner owner) {
        return  vehicleRepository.findByOwner(owner);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        vehicleRepository.updateVehicle(vehicle.getPlateNumber(), vehicle.getModel(),
                vehicle.getYear(), vehicle.getColor());
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }


}
