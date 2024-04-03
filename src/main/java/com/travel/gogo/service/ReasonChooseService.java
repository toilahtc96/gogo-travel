package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.CompanyInformationConverted;
import com.travel.gogo.converted.ReasonChooseConverted;
import com.travel.gogo.entity.CompanyInformation;
import com.travel.gogo.entity.ReasonChoose;
import com.travel.gogo.repository.CompanyInformationRepository;
import com.travel.gogo.repository.ReasonChooseRepository;
import com.travel.gogo.request.ReasonChooseRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReasonChooseService {
    private final ReasonChooseRepository reasonChooseRepository;

    public void add(ReasonChooseRequest reasonChooseRequest) {
        ReasonChoose reasonChoose = ReasonChooseConverted.convertReasonChooseRequest(reasonChooseRequest);
        reasonChooseRepository.save(reasonChoose);
    }

    public boolean edit(ReasonChooseRequest reasonChooseRequest) {
        if (reasonChooseRequest.getId() == null) {
            return false;
        }
        int id = reasonChooseRequest.getId();
        ReasonChoose reasonChoose = reasonChooseRepository.findById(id).orElse(null);
        if (reasonChoose == null) {
            return false;
        }
        reasonChoose.setReasonMain(reasonChooseRequest.getReasonMain());
        reasonChoose.setReasonDescription(reasonChooseRequest.getReasonDescription());
        reasonChoose.setBackgroundImage(reasonChooseRequest.getBackgroundImage());
        reasonChoose.setStatus(reasonChooseRequest.getStatus());
        try {
            reasonChooseRepository.save(reasonChoose);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ReasonChoose getById(int id) {
        ReasonChoose reasonChoose = reasonChooseRepository.findById(id).orElse(null);
        return reasonChoose;
    }

    public List<ReasonChoose> getAll() {
        return reasonChooseRepository.findAll();
    }

    public List<ReasonChoose> getAllActive() {
        return reasonChooseRepository.findAllByStatusOrderByIdDesc(Status.ACTIVE);
    }
    public boolean deleteById(int id) {

        ReasonChoose reasonChoose = reasonChooseRepository.findById(id).orElse(null);
        if (reasonChoose == null) {
            return false;
        }
        reasonChoose.setStatus(Status.BLOCK);
        try {
            reasonChooseRepository.save(reasonChoose);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
