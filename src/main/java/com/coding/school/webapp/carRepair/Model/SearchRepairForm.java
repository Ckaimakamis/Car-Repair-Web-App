package com.coding.school.webapp.carRepair.Model;

import java.sql.Timestamp;

public class SearchRepairForm {

    private String vat;

    private String plateNumber;

    private String date;

    private String dateTo;

    private String periodSeach;

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPeriodSeach() {
        return periodSeach;
    }

    public void setPeriodSeach(String periodSeach) {
        this.periodSeach = periodSeach;
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
