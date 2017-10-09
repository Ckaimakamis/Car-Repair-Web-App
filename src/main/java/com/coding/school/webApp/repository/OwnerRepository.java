package com.coding.school.webApp.repository;

import com.coding.school.webApp.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("OwnerRepository")
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}