package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.AddressConverted;
import com.travel.gogo.converted.CompanyInformationConverted;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.CompanyInformation;
import com.travel.gogo.repository.CompanyInformationRepository;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.CompanyInformationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyInformationService {
    private final CompanyInformationRepository companyInformationRepository;

    public void add(CompanyInformationRequest companyInformationRequest) {
        CompanyInformation companyInformation = CompanyInformationConverted.convertAddressRequest(companyInformationRequest);
        companyInformationRepository.save(companyInformation);
    }

    public boolean edit(CompanyInformationRequest companyInformationRequest) {
        if (companyInformationRequest.getId() == null) {
            return false;
        }
        int id = companyInformationRequest.getId();
        CompanyInformation companyInformation = companyInformationRepository.findById(id).orElse(null);
        if (companyInformation == null) {
            return false;
        }
        companyInformation.setCompanyAddress(companyInformationRequest.getCompanyAddress());
        companyInformation.setCompanyEmail(companyInformationRequest.getCompanyEmail());
        companyInformation.setCompanyName(companyInformationRequest.getCompanyName());
        companyInformation.setCompanyPhone(companyInformationRequest.getCompanyPhone());
        companyInformation.setCompanyCityAddress(companyInformationRequest.getCompanyCityAddress());
        companyInformation.setFacebookLink(companyInformationRequest.getFacebookLink());
        companyInformation.setInstagramLink(companyInformationRequest.getInstagramLink());
        companyInformation.setTikTokLink(companyInformationRequest.getTikTokLink());
        companyInformation.setStatus(companyInformationRequest.getStatus());
        try {
            companyInformationRepository.save(companyInformation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CompanyInformation getById(int id) {
        CompanyInformation companyInformation = companyInformationRepository.findById(id).orElse(null);
        return companyInformation;
    }

    public List<CompanyInformation> getAll() {
        return companyInformationRepository.findAll();
    }
    public CompanyInformation getActive() {
        return companyInformationRepository.findFirstByStatus(Status.ACTIVE);
    }

    public boolean deleteById(int id) {

        CompanyInformation companyInformation = companyInformationRepository.findById(id).orElse(null);
        if (companyInformation == null) {
            return false;
        }
        companyInformation.setStatus(Status.BLOCK);
        try {
            companyInformationRepository.save(companyInformation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
