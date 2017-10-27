package com.coding.school.webapp.carRepair.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PartsType type;

    @NotNull
    private double cost;

    @ManyToOne(optional = false)
    private Repair repair;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public PartsType getType() {
        return type;
    }

    public void setType(PartsType type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public enum PartsType {
        TIRES,BRAKES,FENDER,WINDOWS
    }
}
