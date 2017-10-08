package com.coding.school.webApp.model;

public class Vehicle {

    private Integer ID;
    private String plateNumber;
    private String model;
    private String year;
    private String color;

    public Vehicle() {
    }

    public Vehicle(int ID, String plateNumber, String model, String year, String color) {
        this.ID = ID;
        this.plateNumber = plateNumber;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
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

}
