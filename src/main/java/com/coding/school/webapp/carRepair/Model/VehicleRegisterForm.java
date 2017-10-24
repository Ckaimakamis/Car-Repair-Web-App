package com.coding.school.webapp.carRepair.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class VehicleRegisterForm {

    private static final String PLATE_PATTERN = "[ABEHIKMNOPTOXYZ]{3}-[0123456789]{4}";

    private static final String YEAR_PATTERN = "[0123456789]{4}";

    private static final String VAT_PATTERN = "^[0-9]*$";

    @NotNull(message = "{register.plate.null}")
    @Pattern(regexp = PLATE_PATTERN, message = "{register.plate.invalid")
    private String plateNumber;

    @NotNull(message = "{register.model.null}")
    private String model;

    @NotNull(message = "{register.year.null}")
    @Pattern(regexp = YEAR_PATTERN, message = "{register.year.invalid")
    private String year;

    private String color;

    @NotNull(message = "{register.vat.null}")
    @Pattern(regexp = VAT_PATTERN, message = "{register.vat.invalid")
    private String vat;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}
