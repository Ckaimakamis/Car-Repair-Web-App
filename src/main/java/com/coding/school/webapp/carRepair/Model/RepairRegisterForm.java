package com.coding.school.webapp.carRepair.Model;

import com.coding.school.webapp.carRepair.Domain.Repair;

public class RepairRegisterForm {

    private Long ID;
    private String dateTime;
    private Repair.RepairType type;
    private Repair.RepairStage stage;
    private double cost;
    private String operations;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Repair.RepairType getType() {
        return type;
    }

    public void setType(Repair.RepairType type) {
        this.type = type;
    }

    public Repair.RepairStage getStage() {
        return stage;
    }

    public void setStage(Repair.RepairStage stage) {
        this.stage = stage;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }
}
