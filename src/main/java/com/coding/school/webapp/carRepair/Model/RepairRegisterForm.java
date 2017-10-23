package com.coding.school.webapp.carRepair.Model;

import com.coding.school.webapp.carRepair.Domain.Repair;

import java.sql.Timestamp;

public class RepairRegisterForm {

    private Timestamp dateTime;
    private Repair.RepairType type;
    private Repair.RepairStage stage;
    private double cost;
    private String operations;

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
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
