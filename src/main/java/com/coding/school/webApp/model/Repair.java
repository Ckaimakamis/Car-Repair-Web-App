package com.coding.school.webApp.model;

import java.sql.Timestamp;

public class Repair {

    private int ID;
    private Timestamp dateTime;
    private RepairType type;
    private RepairStage stage;
    private double cost;
    private String operations;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public RepairType getType() {
        return type;
    }

    public void setType(RepairType type) {
        this.type = type;
    }

    public RepairStage getStage() {
        return stage;
    }

    public void setStage(RepairStage stage) {
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

    public enum RepairStage {pending, in_progress, done}
    public enum RepairType {big, small}
}
