package com.coding.school.webapp.carRepair.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class RepairRegisterForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    private String cost;

    private String operations;

    private String repairStage;

    private String repairType;

    private String plateNumber;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getRepairStage() {
        return repairStage;
    }

    public void setRepairStage(String repairStage) {
        this.repairStage = repairStage;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
