package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Exceptions.InvalidCredentialsException;
import com.coding.school.webapp.carRepair.Repositories.OwnerRepository;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    OwnerRepository repository;

    @Override
    public Owner login(String username, String password) throws AuthenticationException {
        Owner owner = repository.findByEmailAndPassword(username, password);
        if(owner != null) {
            return owner;
        }else{
            throw new InvalidCredentialsException("User not found!");
        }
    }
}
