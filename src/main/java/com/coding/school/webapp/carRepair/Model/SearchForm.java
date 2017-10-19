package com.coding.school.webapp.carRepair.Model;

import java.sql.Timestamp;

public class SearchForm {

    private String email;

    private String date;

    private String dateTo;

    // Takes the type of search User/Repair
    private String searchType;

    // If ckeckbox is checked then its value is "period search" else is null
    private String periodSeach;
    private String vat;

    private Timestamp dateTime;

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

    public String getPeriodSeach() {
        return periodSeach;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String isPeriodSeach() {
        return periodSeach;
    }

    public void setPeriodSeach(String periodSeach) {
        this.periodSeach = periodSeach;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}
