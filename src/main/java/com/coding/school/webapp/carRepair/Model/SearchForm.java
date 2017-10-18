package com.coding.school.webapp.carRepair.Model;

import java.sql.Timestamp;

public class SearchForm {

    private String email;

    private Timestamp dateTime;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
