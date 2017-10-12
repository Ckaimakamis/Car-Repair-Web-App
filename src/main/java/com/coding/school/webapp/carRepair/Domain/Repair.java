package com.coding.school.webapp.carRepair.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Column(nullable = false)
    private Timestamp dateTime;

    @NotNull
    @Column(nullable = false)
    private RepairType type;

    private RepairStage stage;

    @NotNull
    @Column(nullable = false)
    private double cost;

    private String operations;

    public Long getID() {
        return ID;
    }
    public void setID(Long ID) {
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

    public enum RepairStage {
        pending, in_progress, done;
    }
    public enum RepairType {big, small}
}