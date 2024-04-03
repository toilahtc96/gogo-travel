package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.ReasonChoose;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.ReasonChooseRequest;

public class ReasonChooseConverted {
    public static ReasonChoose convertReasonChooseRequest(ReasonChooseRequest reasonChooseRequest) {
        return ReasonChoose.builder()
                .id(reasonChooseRequest.getId())
                .reasonMain(reasonChooseRequest.getReasonMain())
                .reasonDescription(reasonChooseRequest.getReasonDescription())
                .backgroundImage(reasonChooseRequest.getBackgroundImage())
                .icon(reasonChooseRequest.getIcon())
                .backgroundImage(reasonChooseRequest.getBackgroundImage())
                .status(Status.ACTIVE)
                .build();
    }
}
