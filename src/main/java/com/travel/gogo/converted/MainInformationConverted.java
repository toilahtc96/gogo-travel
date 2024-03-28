package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.MainInformation;
import com.travel.gogo.request.MainInformationRequest;

public class MainInformationConverted {
    public static MainInformation convertMainInformation(MainInformationRequest mainInformationRequest){
        return MainInformation.builder()
                .id(mainInformationRequest.getId())
                .title(mainInformationRequest.getTitle())
                .description(mainInformationRequest.getDescription())
                .status(Status.ACTIVE)
                .build();
    }
}
