package com.travel.gogo.repository;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.ReasonChoose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReasonChooseRepository extends JpaRepository<ReasonChoose, Integer> {
    List<ReasonChoose> findAllByStatusOrderByIdDesc(Status status);
}
