package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import org.springframework.security.core.AuthenticationException;

public interface OwnerService {

    Owner login(String username, String password) throws AuthenticationException;

    void registerOwner(Owner owner) throws AuthenticationException;

}