package com.coding.school.webapp.carRepair.Exceptions;

import org.springframework.security.core.AuthenticationException;

public class RepairExistException extends AuthenticationException {

    public RepairExistException(String msg, Throwable t) {
        super(msg, t);
    }

    public RepairExistException(String msg) {
        super(msg);
    }
}
