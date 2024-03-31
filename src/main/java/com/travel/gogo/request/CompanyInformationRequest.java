package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class CompanyInformationRequest {
    private Integer id;
    private String companyName;
    private String companyAddress;
    private String companyCityAddress;
    private String companyEmail;
    private String companyPhone;
    private String facebookLink;
    private String instagramLink;
    private String tikTokLink;
    private Status status;
}
