package com.travel.gogo.repository;

import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registrations, Integer> {
}
