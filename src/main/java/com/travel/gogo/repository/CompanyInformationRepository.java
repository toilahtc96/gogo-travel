package com.travel.gogo.repository;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.CompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Integer> {
    CompanyInformation findFirstByStatus(Status status);
}
