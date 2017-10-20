package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Vehicle;

public interface VehicleService {

    void registerVehicle(Vehicle vehicle);

    Vehicle findByPlateNumber(String plate);

    Vehicle findByPlateNumberOrVat(String plate, String vat);

    Vehicle findByOwner(Owner owner);
}
