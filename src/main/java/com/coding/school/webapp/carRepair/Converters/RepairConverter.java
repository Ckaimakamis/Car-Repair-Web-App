package com.coding.school.webapp.carRepair.Converters;

import com.coding.school.webapp.carRepair.Domain.Parts;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Model.RepairForAllForm;
import com.coding.school.webapp.carRepair.Model.RepairRegisterForm;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RepairConverter {

    public static Repair buildRepairObject(RepairForAllForm registrationForm) {
        Repair repair = new Repair();
        if(!(registrationForm.getID() == null || registrationForm.getID().equals(""))){
            repair.setID(Long.parseLong(registrationForm.getID().split("/")[0]));
        }
        repair.setStage(repairStageConvert(registrationForm.getRepairStage()));
        repair.setType(repairTypeConvert(registrationForm.getRepairType()));
        repair.setDateTime(registrationForm.getDateTime());
        repair.setParts(registrationForm.getPartsForms().stream().map(e -> PartsConverter.buildPartsObject(e, repair)).collect(Collectors.toList()));
        repair.setCost(0.0);
        List<Parts> parts = (List<Parts>) repair.getParts();
        for(Parts part : parts){
            repair.setCost(repair.getCost() + part.getCost());
        }
        return repair;
    }

    public static Repair buildRepairFromRegisterObject(RepairRegisterForm registrationForm) {
        Repair repair = new Repair();
        if(!(registrationForm.getID() == null || registrationForm.getID().equals(""))){
            repair.setID(Long.parseLong(registrationForm.getID().split("/")[0]));
        }
        repair.setStage(repairStageConvert(registrationForm.getRepairStage()));
        repair.setType(repairTypeConvert(registrationForm.getRepairType()));
        repair.setDateTime(registrationForm.getDateTime());
        repair.setParts(registrationForm.getPartsForms().stream().map(e -> PartsConverter.buildPartsObject(e, repair)).collect(Collectors.toList()));
        repair.setCost(0.0);
        List<Parts> parts = (List<Parts>) repair.getParts();
        for(Parts part : parts){
            repair.setCost(repair.getCost() + part.getCost());
        }
        return repair;
    }

    private static Repair.RepairType repairTypeConvert(String type) {
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

    private static Repair.RepairStage repairStageConvert(String stage){
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

    public static LocalDateTime getStartOfDay(LocalDateTime dateTime){
        String str = dateTime.toString();
        String[] string = str.split("T");
        String startStr = string[0] + "T" + "00:01";
        return LocalDateTime.parse(startStr);
    }

    public static LocalDateTime getEndOfDay(LocalDateTime dateTime){
        String str = dateTime.toString();
        String[] string = str.split("T");
        String endStr = string[0] + "T" + "23:59";
        return LocalDateTime.parse(endStr);
    }
}