package com.travel.gogo.repository;

import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
