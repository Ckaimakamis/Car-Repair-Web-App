package com.coding.school.webapp.carRepair.Model;

import java.sql.Timestamp;

public class SearchRepairForm {

    private String vat;

    private String plateNumber;

    private String date;

    private String dateTo;

    private String periodSearch;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPeriodSearch() {
        return periodSearch;
    }

    public void setPeriodSearch(String periodSearch) {
        this.periodSearch = periodSearch;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
