package com.travel.gogo.repository;

import com.travel.gogo.entity.Role;
import com.travel.gogo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
