package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Repair;

import java.util.ArrayList;

public interface RepairService {

    Repair findById(Long ID);

    ArrayList<Repair> findAll();
}
