package com.travel.gogo.repository;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.MainInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainInformationRepository extends JpaRepository<MainInformation, Integer> {
    MainInformation findFirstByStatus(Status status);
}
