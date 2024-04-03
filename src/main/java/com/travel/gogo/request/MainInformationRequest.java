package com.travel.gogo.request;

import com.travel.gogo.constans.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MainInformationRequest {
    private Integer id;
    private String title;
    private String subtitle;
    private String smallInformation1;
    private String smallInformation2;
    private String heroImage;
    @Enumerated(EnumType.STRING)
    private Status status;
}
