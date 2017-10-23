package com.coding.school.webapp.carRepair.Converters;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Model.RepairRegisterForm;

public class RepairConverter {


    public static Repair buildRepairObject(RepairRegisterForm registrationForm) {
        Repair repair = new Repair();
        repair.setCost(Double.parseDouble(registrationForm.getCost()));
        repair.setOperations(registrationForm.getOperations());
        repair.setStage(repairStageConvert(registrationForm.getRepairStage()));
        repair.setType(repairTypeConvert(registrationForm.getRepairType()));
        repair.setDateTime(registrationForm.getDate());
        return repair;
    }

    public static Repair.RepairType repairTypeConvert(String type) {
        Repair.RepairType repairType = null;
        switch (type) {
            case "SMALL":
                repairType = Repair.RepairType.SMALL;
                break;
            case "BIG":
                repairType = Repair.RepairType.BIG;
                break;
        }
        return repairType;
    }

    public static Repair.RepairStage repairStageConvert(String stage){
        Repair.RepairStage repairStage = null;
        switch (stage){
            case "PENDING":
                repairStage = Repair.RepairStage.PENDING;
                break;
            case "IN_PROGRESS":
                repairStage = Repair.RepairStage.IN_PROGRESS;
                break;
            case "DONE":
                repairStage = Repair.RepairStage.DONE;
                break;
        }
        return repairStage;
    }
}