package com.coding.school.webapp.carRepair.Exceptions;

import org.springframework.security.core.AuthenticationException;

public class VehicleExistException extends AuthenticationException {

    public VehicleExistException(String msg, Throwable t) {
        super(msg, t);
    }

    public VehicleExistException(String msg) {
        super(msg);
    }
}
