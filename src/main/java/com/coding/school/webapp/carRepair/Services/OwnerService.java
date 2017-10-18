package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.AuthenticationException;

public interface OwnerService {

    Owner login(String username, String password) throws AuthenticationException;

    void registerOwner(Owner owner) throws AuthenticationException;

    Owner findByEmail(String email);

    Owner findByEmailOrVat(String email , String vat);

    Owner findByVat( String vat);

    void updateOwner(Owner owner);
}