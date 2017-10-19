package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

    Owner findByEmailAndPassword(String username, String password);

    Owner findByEmail(String email);

    Owner findByEmailOrVat(String email , String vat);

    Owner findByVat(String vat);

    @Transactional
    @Modifying
    @Query("UPDATE Owner as o SET o.email=?1, o.firstName=?2, o.lastName=?3, " +
            "o.password=?4, o.role=?5, o.vat=?6 WHERE o.email=?1")
    void updateOwner(String email, String firstName, String lastName,
                     String password, Owner.OwnerRole role, String vat);


}
