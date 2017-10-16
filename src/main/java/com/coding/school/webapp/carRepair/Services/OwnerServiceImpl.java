package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    OwnerRepository ownerRepository;

    public Owner findById(Long ID){
        Owner owner = ownerRepository.findOne(ID);
        if(owner != null){
            return owner;
        } else{
            return null;
        }
    }
   public boolean registerOwner(Owner owner){
        //prpei na elegxei an iparxei hdh o xristis mesa sti vash
       try {
           ownerRepository.save(owner);
           return true;
       }catch (Exception e){
           return false;
       }
    }

}