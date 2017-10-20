package com.coding.school.webapp.carRepair.Converters;

import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Model.RepairRegisterForm;

public class RepairConverter {


    public static Repair buildRepairObject(RepairRegisterForm registrationForm){

        Repair repair = new Repair();
        repair.setCost(registrationForm.getCost());
        repair.setDateTime(registrationForm.getDateTime());
        repair.setOperations(registrationForm.getOperations());
        repair.setStage(registrationForm.getStage());
        if(registrationForm.getType().equals("BIG")||registrationForm.getType().equals("big")){
            repair.setType(Repair.RepairType.BIG);
        }else{
            repair.setType(Repair.RepairType.SMALL);
        }

        if(registrationForm.getStage().equals("PENDING")||registrationForm.getStage().equals("pending")){
            repair.setStage(Repair.RepairStage.PENDING);
        }else if (registrationForm.getStage().equals("IN_PROGRESS")||registrationForm.getStage().equals("in_progress")){
            repair.setStage(Repair.RepairStage.IN_PROGRESS);
        }
        else{
            repair.setStage(Repair.RepairStage.DONE);
        }

        return repair;
    }

}
/*  public enum RepairStage {
        PENDING, IN_PROGRESS, DONE;
    } */