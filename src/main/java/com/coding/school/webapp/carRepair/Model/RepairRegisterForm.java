package com.coding.school.webapp.carRepair.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

public class RepairRegisterForm {

    private static final String COST_PATTERN = "[0-9]+([,.][0-9]{1,2})?";

    private String ID;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    @NotNull(message = "{register.cost.null}")
    @Pattern(regexp = COST_PATTERN, message = "{register.cost.invalid")
    private String cost;

    @NotNull(message = "{register.operations.null}")
    private String operations;

    @NotNull(message = "{register.stage.null}")
    private String repairStage;

    @NotNull(message = "{register.repairType.null}")
    private String repairType;

    private String plateNumber;

    private List<PartsForm> partsForms;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getRepairStage() {
        return repairStage;
    }

    public void setRepairStage(String repairStage) {
        this.repairStage = repairStage;
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
