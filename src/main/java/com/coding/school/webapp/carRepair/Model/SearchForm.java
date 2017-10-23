package com.coding.school.webapp.carRepair.Model;

import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

public class SearchForm {

    private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final String VAT_PATTERN = "^[0-9]*$";

    private static final String PLATE_PATTERN = "[ABEHIKMNOPTOXYZ]{3}-[0123456789]{4}";

    @Pattern(regexp = EMAIL_PATTERN, message = "{register.email.invalid}")
    private String email;

    private String date;

    private String dateTo;

    @Pattern(regexp = VAT_PATTERN, message = "{register.vat.invalid")
    private String vat;

    @Pattern(regexp = PLATE_PATTERN, message = "{register.plate.invalid")
    private String plateNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
