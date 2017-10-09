package com.coding.school.webApp.service;

import com.coding.school.webApp.model.Owner;
import com.coding.school.webApp.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("OwnerService")
public class OwnerService {

    @Autowired
    @Qualifier("OwnerRepository")
    OwnerRepository repository;

    public Owner findById(int ID){
        Owner owner = repository.findOne(ID);
        if(owner != null){
            return owner;
        } else{
            return null;
        }
    }
}
