package com.coding.school.webapp.carRepair.Model;

import com.coding.school.webapp.carRepair.Domain.Parts;

public class PartsForm {


    private Parts.PartsType type;
    private double cost;

    public Parts.PartsType getType() {
        return type;
    }

    public void setType(Parts.PartsType type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    

}
