package com.travel.gogo.converted;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Address;
import com.travel.gogo.entity.CompanyInformation;
import com.travel.gogo.request.AddressRequest;
import com.travel.gogo.request.CompanyInformationRequest;

public class CompanyInformationConverted {
    public static CompanyInformation convertAddressRequest(CompanyInformationRequest companyInformationRequest) {
        return CompanyInformation.builder()
                .id(companyInformationRequest.getId())
                .companyAddress(companyInformationRequest.getCompanyAddress())
                .companyCityAddress(companyInformationRequest.getCompanyCityAddress())
                .companyName(companyInformationRequest.getCompanyName())
                .companyPhone(companyInformationRequest.getCompanyPhone())
                .companyEmail(companyInformationRequest.getCompanyEmail())
                .instagramLink(companyInformationRequest.getInstagramLink())
                .facebookLink(companyInformationRequest.getFacebookLink())
                .tikTokLink(companyInformationRequest.getTikTokLink())
                .status(companyInformationRequest.getStatus())
                .build();
    }
}
