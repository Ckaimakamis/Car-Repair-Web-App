package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;
import com.coding.school.webapp.carRepair.Repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
   public void registerOwner(Owner owner){
        //prpei na elegxei an iparxei hdh o xristis mesa sti vash
         ownerRepository.save(owner);

    }

    @Override
    public Owner findByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }

}