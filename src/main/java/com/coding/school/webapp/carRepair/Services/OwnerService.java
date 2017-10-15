package com.coding.school.webapp.carRepair.Services;

import com.coding.school.webapp.carRepair.Domain.Owner;

public interface OwnerService {

     Owner findById(Long ID);

        void registerOwner(Owner owner);

     }
