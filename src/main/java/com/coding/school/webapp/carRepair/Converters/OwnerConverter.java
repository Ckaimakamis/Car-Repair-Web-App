package com.coding.school.webapp.carRepair.Converters;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Domain.Repair;
import com.coding.school.webapp.carRepair.Model.RegisterForm;

public class OwnerConverter {

    public static Owner buildUserObject(RegisterForm registrationForm){
        Owner owner = new Owner();
        owner.setEmail(registrationForm.getEmail());
        owner.setFirstName(registrationForm.getFirstName());
        owner.setLastName(registrationForm.getLastName());
        owner.setPassword(registrationForm.getPassword());
        if(registrationForm.getRole().equals("ADMIN") || registrationForm.getRole().equals("admin")){
            owner.setRole(Owner.OwnerRole.ADMIN);
        } else{
            owner.setRole(Owner.OwnerRole.USER);
        }
        owner.setVat(registrationForm.getVat());
        return owner;
    }


}
