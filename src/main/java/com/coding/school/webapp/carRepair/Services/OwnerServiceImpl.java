package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Exceptions.InvalidCredentialsException;
import com.coding.school.webapp.carRepair.Exceptions.UserExistException;
import com.coding.school.webapp.carRepair.Repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    OwnerRepository ownerRepository;

    private static Map<String, Owner> loggedInUsers = new HashMap<>();

    @Override
    public Owner login(String username, String password) throws AuthenticationException {
        Owner owner = ownerRepository.findByEmailAndPassword(username, password);
        if(owner != null) {
            loggedInUsers.put(getCredentials(username, password), owner);
            return owner;
        }else{
            throw new InvalidCredentialsException("User not found!");
        }
    }

    @Override
    public void registerOwner(Owner owner) throws AuthenticationException{
        Owner existedOwner = ownerRepository.findByEmail(owner.getEmail());
        if(existedOwner == null){
            ownerRepository.save(owner);
        }else {
            throw new UserExistException("Email already exists!");
        }
    }

    private static String getCredentials(String username, String password) {
        return username + ":" + password;
    }

}