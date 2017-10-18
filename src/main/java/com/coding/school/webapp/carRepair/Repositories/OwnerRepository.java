package com.coding.school.webapp.carRepair.Repositories;

import com.coding.school.webapp.carRepair.Domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

    Owner findByEmailAndPassword(String username, String password);

    Owner findByEmail(String email);

    Owner findByEmailOrVat(String email , String vat);

    Owner findByVat( String vat);

}
