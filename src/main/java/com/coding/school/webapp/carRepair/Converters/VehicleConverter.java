package com.coding.school.webapp.carRepair.Converters;

import com.coding.school.webapp.carRepair.Domain.Vehicle;
import com.coding.school.webapp.carRepair.Model.VehicleRegisterForm;

public class VehicleConverter {

    public static Vehicle buildVehicleObject(VehicleRegisterForm registrationForm){
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(registrationForm.getColor());
        vehicle.setModel(registrationForm.getModel());
        vehicle.setPlateNumber(registrationForm.getPlateNumber());
        vehicle.setYear(registrationForm.getYear());
        return vehicle;
    }
}
