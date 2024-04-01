package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.MainInformationConverted;
import com.travel.gogo.entity.MainInformation;
import com.travel.gogo.repository.MainInformationRepository;
import com.travel.gogo.request.MainInformationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MainInformationService {

    private final MainInformationRepository mainInformationRepository;

    public void addMainInformation(MainInformationRequest mainInformationRequest){
        MainInformation mainInformation = MainInformationConverted.convertMainInformation(mainInformationRequest);
        mainInformationRepository.save(mainInformation);
    }

    public List<MainInformation> getAll(){
        return mainInformationRepository.findAll();
    }

    public MainInformation getMainInforById(int id){
        return mainInformationRepository.findById(id).orElse(null);
    }

    public boolean editMainInfor(MainInformationRequest mainInformationRequest){
        if (mainInformationRequest.getId() == null){
            return false;
        }
        int id = mainInformationRequest.getId();
        MainInformation mainInformation = mainInformationRepository.findById(id).orElse(null);
        mainInformation.setTitle(mainInformationRequest.getTitle());
        mainInformation.setSubtitle(mainInformationRequest.getSubtitle());
        mainInformation.setSmallInformation1(mainInformationRequest.getSmallInformation1());
        mainInformation.setSmallInformation2(mainInformationRequest.getSmallInformation2());
        mainInformation.setHeroImage(mainInformationRequest.getHeroImage());
        try {
            mainInformationRepository.save(mainInformation);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean deleteMainInfor(int id){
        MainInformation mainInformation = mainInformationRepository.findById(id).orElse(null);
        if (mainInformation == null){
            return false;
        }
        mainInformation.setStatus(Status.BLOCK);
        try {
            mainInformationRepository.delete(mainInformation);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
