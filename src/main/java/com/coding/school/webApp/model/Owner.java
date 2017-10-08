package com.coding.school.webApp.model;

public class Owner {
    private int ID;
    private String firstName;
    private String lastName;
    private String vat;
    private String email;
    private String password;
    private OwnerRole role;

    public Owner() {
    }

    public Owner(int ID, String firstName, String lastName, String vat, String email, String password, OwnerRole role) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vat = vat;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVat() {
        return vat;
    }
    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public OwnerRole getRole() {
        return role;
    }
    public void setRole(OwnerRole role) {
        this.role = role;
    }

    public enum OwnerRole {admin, user}
}
