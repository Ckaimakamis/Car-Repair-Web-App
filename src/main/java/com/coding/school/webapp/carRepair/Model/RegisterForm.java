package com.coding.school.webapp.carRepair.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";

    private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static final int PASSWORD_MINSIZE = 6;

    private static final String VAT_PATTERN = "^[0-9]*$";

    @NotNull
    @Pattern(regexp = EMAIL_PATTERN, message = "{register.email.invalid}")
    private String email;

    @NotNull
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.firstname.invalid}")
    private String firstName;

    @NotNull
    @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.lastname.invalid}")
    private String lastName;

    @NotNull(message = "{register.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{register.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, message = "{register.password.size}")
    private String password;

    @NotNull
    private String role;

    @NotNull
    @Pattern(regexp = VAT_PATTERN, message = "{register.vat.invalid")
    private String vat;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}
