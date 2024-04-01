package com.travel.gogo.repository;

import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Registrations;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends CrudRepository<Registrations, Integer> {

    List<Registrations> findAll(Pageable pageable);
}
