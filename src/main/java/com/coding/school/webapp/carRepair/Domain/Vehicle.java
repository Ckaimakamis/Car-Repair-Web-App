package com.coding.school.webapp.carRepair.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Column(nullable = false)
    private String plateNumber;

    @NotNull
    @Column(nullable = false)
    private String model;

    @NotNull
    @Column(nullable = false)
    private String year;

    @NotNull
    @Column(nullable = false)
    private String color;

    @ManyToOne(optional = false)
    private Owner owner;

    @OneToMany(mappedBy = "vehicle")
    private Collection<Repair> repairs;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getPlateNumber() { return plateNumber; }

    public void setPlateNumber(String plateNumber) { this.plateNumber = plateNumber; }

    public String getModel() { return model; }

    public void setModel(String model) { this.model = model; }

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Collection<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Collection<Repair> repairs) {
        this.repairs = repairs;
    }
}
