package com.coding.school.webApp.model;

public class Vehicle {

    private String plateNumber;
    private String model;
    private String year;
    private String color;

    public Vehicle() {
    }

    public Vehicle(String plateNumber, String model, String year, String color) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.year = year;
        this.color = color;
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
