package com.coding.school.webapp.carRepair.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class SearchRepairForm {

    private static final String VAT_PATTERN = "^[0-9]*$";

    private static final String PLATE_PATTERN = "[ABEHIKMNOPTOXYZ]{3}-[0123456789]{4}";

    @Pattern(regexp = VAT_PATTERN, message = "{register.vat.invalid")
    private String vat;

    @Pattern(regexp = PLATE_PATTERN, message = "{register.plate.invalid")
    private String plateNumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTo;

    private String searchType;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }
}