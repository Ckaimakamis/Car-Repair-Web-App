package com.coding.school.webapp.carRepair.Exceptions;

import org.springframework.security.core.AuthenticationException;

public class UserExistException extends AuthenticationException {

    public UserExistException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserExistException(String msg) {
        super(msg);
    }


}
