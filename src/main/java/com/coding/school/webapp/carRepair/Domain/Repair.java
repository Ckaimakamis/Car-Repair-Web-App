package com.coding.school.webapp.carRepair.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private RepairType type;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private RepairStage stage;

    @NotNull
    @Column(nullable = false)
    private double cost;

    @ManyToOne(optional = false)
    private Vehicle vehicle;

    @ManyToMany(mappedBy = "repair")
    private Collection<Parts> parts;


    public Collection<Parts> getParts() {
        return parts;
    }

    public void setParts(Collection<Parts> parts) {
        this.parts = parts;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public enum RepairStage {
        PENDING, IN_PROGRESS, DONE;
    }

    public enum RepairType {
        BIG, SMALL
    }
}
